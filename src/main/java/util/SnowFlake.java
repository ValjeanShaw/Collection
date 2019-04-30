package util;

/**
 * @author xiaoran
 * @date 2019/04/29
 */
public class SnowFlake {
    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1556518889000L;


    /**
     * 序列号占用的位数    12bit
     */
    private final static long SEQUENCE_BIT = 12;
    /**
     * 数据中心占用位数   5bit
     */
    private final static long DATACENTER_BIT = 5;
    /**
     * 机器号占用位数     5bit
     */
    private final static long MACHINE_BIT = 5;
    /**
     * 利用位运算计算出n位能表示的最大正整数
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);
    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心
     */
    private long datacenterId;
    /**
     * 机器标识
     */
    private long machineId;
    /**
     * 序列号
     */
    private long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastStamp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }


    /**
     * 产生下一个ID，此方法必须加锁
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = System.currentTimeMillis();
        if (currStmp < lastStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStamp) {
            //if条件里表示当前调用和上一次调用落在了相同毫秒内，只能通过第三部分，序列号自增来判断为唯一，所以+1.  不能超过最大数
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大，只能等待下一个毫秒
            if (sequence == 0L) {
                //进入下一毫秒运算，sequence从0开始+1
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            //执行到这个分支的前提是currTimestamp > lastTimestamp，说明本次调用跟上次调用对比，已经不再同一个毫秒内了，这个时候序号可以重新回置0了。
            sequence = 0L;
        }

        lastStamp = currStmp;
        /**
         * 就是用相对毫秒数、机器ID和自增序号拼接    时间戳部分  数据中心部分  机器标识部分  序列号部分
         */
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    /**
     * 一直循环，等待下一个比上次生成id的时间戳大的时间戳
     *
     * @return
     */
    private long getNextMill() {
        long mill = System.currentTimeMillis();
        while (mill <= lastStamp) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }


    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        // 构造方法设置机器码：第9个机房的第20台机器
        SnowFlake snowFlake = new SnowFlake(9, 20);
        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(snowFlake.nextId());
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
