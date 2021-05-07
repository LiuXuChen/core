package com.jetco.core.creative.singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.IdGenerator;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 *
 * 单例模式：确保一个类只能有一个实例[进程唯一]，并提供全局访问点
 *
 * 分为两大类：
 * 懒汉模式：实例在第一次使用时创建
 * 饿汉模式：实例在类加载时创建
 *
 * 使用场景：
 * 1⃣️ 要求生成唯一序列号的环境、系统的配置信息类、唯一连接对象（线程池、缓存池、数据库连接池、日志对象）等
 * 2⃣️ 网站计数器
 * 3⃣️ 文件系统、打印机、资源管理器等，因为底层资源只能同时被一方操纵
 * 4⃣️ Java中的dao、service一般都是单例的，而controller层一般都是多例
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-01
 */
@Slf4j
public final class Singleton {

    /**
     * 使用private将构造方法私有化，以防外界通过该构造方法创建多个实例
     */
    private Singleton() {

    }

    /**
     * 饿汉式：不支持延迟加载
     * 优点：类加载都内存后，就实例化一个单例，JVM保证线程安全，简单实用，推荐使用
     * 缺点：
     *      由于instance的初始化是在类加载时进行的，类加载是由ClassLoader来实现的，如果初始化太早，就会造成资源浪费
     * 类加载的时机：
     *      1⃣️ new一个对象时
     *      2⃣️ 使用反射创建它的实例时
     *      3⃣️ 子类被加载时，如果父类还没有被加载，就先加载父类
     *      4⃣️ jvm启动时执行主类会先被加载
     *
     */
//    // 私有化的类成员变量
//    private static final Singleton instance = new Singleton();
//
//    // 公共的类实例的访问方法
//    public static Singleton getInstance() {
//        return instance;
//    }


    // ==========================================================

    /**
     * 懒汉式：支持延时加载
     * 有性能瓶颈
     */
//    private static volatile Singleton instance = null;

//     // 方法级别的锁
//    public static Singleton getInstance() {
//        // 避免多线程导致多个实例的情况，影响效率
//        synchronized (Singleton.class) {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
//    }

    // ==========================================================

    /**
     * 懒汉式
     * volatile的作用是禁止指令重排
     */
//    private static volatile Singleton instance = null;

    /**
     * 双重校验锁
     * 既支持延迟加载、又支持高并发的单例
     */
//    public static Singleton getInstance() {
//        // 解决上面代码中的效率问题
//        if (instance == null) {
//            // 类级别的锁
//            synchronized (Singleton.class) {
//                // 防止可能出现多个实例的情况
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 采用CAS实现单例
     */
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();

    public static Singleton getInstance() {
        for(;;) {
            Singleton singleton = INSTANCE.get();
            if (singleton != null) {
                return singleton;
            }
            singleton = new Singleton();
            if(!INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

    // ==========================================================

    /**
     * 静态内部类
     * JVM保证单例
     * 对于内部类SingletonHolder，它是一个饿汉式的单例实现，
     * 利用了ClassLoader来保证同步，同时又能让开发者控制类加载的时机
     */
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    /**
//     * 从外部来看，是懒汉式式的实现
//     */
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }

    // ==========================================================

    /**
     * 枚举实现，最优方法，不仅可以解决线程同步，还可以防止反序列化
     */
//    enum SingleInstance {
//        /**
//         * 使用SingleInstance.INSTANCE.toString();
//         */
//        INSTANCE;
//
//        @Override
//        public String toString() {
//            return super.toString();
//        }
//    }


    /**
     * 单例不支持有参数的构造函数，该如何解决？
     */

    /**
     * 思路一：
     * 创建完实例之后，再调用 init() 函数传递参数。需要注意的是，我们在使用这个单例类的时候，
     * 要先调用 init() 方法，然后才能调用 getInstance() 方法，否则代码会抛出异常。代码如下：
     */
//    private static Singleton instance = null;
//    private final int paramA;
//    private final int paramB;
//    private Singleton(int paramA, int paramB) {
//        this.paramA = paramA;
//        this.paramB = paramB;
//    }
//    public static Singleton getInstance() {
//        if (instance == null) {
//            log.info("init() 第一次运行。。。。。。");
//        }
//        return instance;
//    }
//
//    public synchronized static Singleton init(int paramA, int paramB) {
//        if (instance != null) {
//            log.info("单例正在被创建。。。。。。");
//        }
//        instance = new Singleton(paramA, paramB);
//        return instance;
//    }


    /**
     * 思路二：【有问题，需改进】
     * 将参数放到 getInstance() 方法中。代码如下：
     */
//    private static Singleton instance = null;
//    private final int paramA;
//    private final int paramB;
//    private Singleton(int paramA, int paramB) {
//        this.paramA = paramA;
//        this.paramB = paramB;
//    }
//    public synchronized static Singleton getInstance(int paramA, int paramB) {
//        if (instance == null) {
//            instance = new Singleton(paramA, paramB);
//        }
//        return instance;
//    }

    /**
     * 思路三：【推荐】
     * 将参数放到另外一个全局变量中。Config 是一个存储了 paramA 和 paramB 值的全局变量。
     * 里面的值既可以像下面的代码那样通过静态常量来定义，也可以从配置文件中加载得到。代码如下：
     */
//    class Config {
//        public static final int PARAM_A = 10;
//        public static final int PARAM_B = 50;
//    }
//
//    private static Singleton instance = null;
//    private final int paramA;
//    private final int paramB;
//    private Singleton() {
//        this.paramA = Config.PARAM_A;
//        this.paramB = Config.PARAM_B;
//    }
//    public synchronized static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }


    /**
     * 以上单例为进程间唯一，那么如何实现线程唯一的单例？
     * 思路：
     * 我们通过一个 HashMap 来存储对象，其中 key 是线程 ID，value 是对象。
     * 这样我们就可以做到不同的线程对应不同的对象，同一个线程只能对应一个对象。
     * 实际上，Java 语言本身提供了 ThreadLocal 工具类，可以更加轻松地实现线程唯一单例。
     * 不过，ThreadLocal底层实现原理也是基于下面代码中所示的 HashMap。
     */
//    private final AtomicLong id = new AtomicLong(0);
//    private static final ConcurrentHashMap<Long, Singleton> instances = new ConcurrentHashMap<>();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        Long currentThreadId = Thread.currentThread().getId();
//        instances.putIfAbsent(currentThreadId, new Singleton());
//        return instances.get(currentThreadId);
//    }
//    public long getId() { return id.incrementAndGet(); }

    /**
     * 如何实现集群环境下的单例？[以下代码为伪代码]
     * 思路：
     * 我们需要把这个单例对象序列化并存储到外部共享存储区（比如文件）。
     * 进程在使用这个单例对象的时候，需要先从外部共享存储区中将它读取到内存，
     * 并反序列化成对象，然后再使用，使用完成之后还需要再存储回外部共享存储区。
     * 为了保证任何时刻，在进程间都只有一份对象存在，一个进程在获取到对象之后，需要对对
     * 象加锁，避免其他进程再将其获取。在进程使用完这个对象之后，
     * 还需要显式地将对象从内存中删除，并且释放对对象的加锁。
     */
//    private AtomicLong id = new AtomicLong(0);
//    private static Singleton instance;
//    // 入参省略
//    private static SharedObjectStorage storage = FileSharedObjectStorage();
//    private static DistributedLock lock = new DistributedLock();
//    private Singleton() {}
//    public synchronized static Singleton getInstance() {
//        if (instance == null) {
//            lock.lock();
//            instance = storage.load(Singleton.class);
//        }
//        return instance;
//    }
//
//    public synchronized void freeInstance() {
//        storage.save(this, Singleton.class);
//        //释放对象
//        instance = null;
//        lock.unlock();
//    }
//
//    public long getId() {
//        return id.incrementAndGet();
//    }

    /**
     * 如何实现一个多例模式？
     * “多例”指的就是，一个类可以创建多个对象，但是个数是有限制的，比如只能创建 3 个对象。
     */
    static class BackendServer {
        private final int serverNo;
        private final String serverAddress;
        private static final int SERVER_COUNT = 3;
        private static final Map<Integer, BackendServer> SERVER_INSTANCES = new HashMap<>();

        {
            SERVER_INSTANCES.put(1, new BackendServer(1, "192.134.22.138:8080"));
            SERVER_INSTANCES.put(2, new BackendServer(2, "192.134.22.139:8080"));
            SERVER_INSTANCES.put(3, new BackendServer(3, "192.134.22.140:8080"));
        }
        private BackendServer(int serverNo, String serverAddress) {
            this.serverNo = serverNo;
            this.serverAddress = serverAddress;
        }
        public BackendServer getInstance(int serverNo) {
            return SERVER_INSTANCES.get(serverNo);
        }
        public BackendServer getRandomInstance() {
            SecureRandom r = new SecureRandom();
            int no = r.nextInt(SERVER_COUNT)+1;
            return SERVER_INSTANCES.get(no);
        }
    }


}
