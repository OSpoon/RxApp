### 备注:
###### (摘录自网络文章)
ObservableEmitter(发射器)

    三种类型的事件
    onNext(T value)
    onComplete()
    onError(Throwable error)

发送和接收

    1.上游可以发送无限个onNext, 下游也可以接收无限个onNext.
    2.当上游发送了一个onComplete后, 上游onComplete之后的事件将会继续发送, 而下游收到onComplete事件之后将不再继续接收事件.
    3.当上游发送了一个onError后, 上游onError之后的事件将继续发送, 而下游收到onError事件之后将不再继续接收事件.
    4.上游可以不发送onComplete或onError.
    5.最为关键的是onComplete和onError必须唯一并且互斥, 即不能发多个onComplete, 也不能发多个onError, 也不能先发一个onComplete, 然后再发一个onError, 反之亦然
    注: 关于onComplete和onError唯一并且互斥这一点, 是需要自行在代码中进行控制, 如果你的代码逻辑中违背了这个规则, 并不一定会导致程序崩溃. 比如发送多个onComplete是可以正常运行的, 依然是收到第一个onComplete就不再接收了, 但若是发送多个onError, 则收到第二个onError事件会导致程序会崩溃.

Disposable(可任意处理的)

    达到设置临界点自动断开(Disposable.dispose())

线程切换

    多次指定上游的线程只有第一次指定的有效, 也就是说多次调用subscribeOn() 只有第一次的有效, 其余的会被忽略.
    Observable.subscribeOn(Schedulers.newThread())//指定发送线程位置

    多次指定下游的线程是可以的, 也就是说每调用一次observeOn() , 下游的线程就会切换一次.
    Observable.subscribeOn(AndroidSchedulers.mainThread())//指定接收线程位置

    在RxJava中, 已经内置了很多线程选项供我们选择, 例如有

    1.Schedulers.io()
    代表io操作的线程, 通常用于网络,读写文件等io密集型的操作

    2.Schedulers.computation()
    代表CPU计算密集型的操作, 例如需要大量计算的操作

    3.Schedulers.newThread()
    代表一个常规的新线程

    4.AndroidSchedulers.mainThread()
    代表Android的主线程

CompositeDisposable.clear() 切断所有的水管

    Activity销毁时调用,防止网络返回数据更新UI时崩溃,效果等于Disposable.dispose()

Zip通过一个函数将多个Observable发送的事件结合到一起，然后发送这些组合到一起的事件. 它按照严格的顺序应用这个函数。它只发射与发射数据项最少的那个Observable一样多的数据。

sample(2, TimeUnit.SECONDS) sample取样 每隔指定的时间就从上游中取出一个事件发送给下游

