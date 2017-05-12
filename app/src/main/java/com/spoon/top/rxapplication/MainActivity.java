package com.spoon.top.rxapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spoon.top.rxapplication.bean.GankAndroid;
import com.spoon.top.rxapplication.retrofit2.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.tv_test1);
        textView2 = (TextView) findViewById(R.id.tv_test2);
        textView3 = (TextView) findViewById(R.id.tv_test3);
        textView4 = (TextView) findViewById(R.id.tv_test4);
        textView5 = (TextView) findViewById(R.id.tv_test5);
        textView6 = (TextView) findViewById(R.id.tv_test6);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test3();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test4();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test5();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test6();
            }
        });
    }

    /**
     * 普通模式
     */
    public void test1() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("hello 1号");
                e.onNext("hello 2号");
                e.onNext("hello 3号");
                e.onComplete();//完成标记
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("RX", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("RX", "onNext ->" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("RX", e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("RX", "onComplete");
            }
        });
    }

    /**
     * 线程切换模式
     */
    public void test2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.d("RX", "subscribe" + Thread.currentThread().getName());
                e.onNext("hello 1号");
            }
        })
                .subscribeOn(Schedulers.newThread())//指定发送线程位置
                .observeOn(AndroidSchedulers.mainThread())//指定接收线程位置
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.d("RX", "accept" + Thread.currentThread().getName());
                        Log.d("RX", "accept" + s);
                        textView2.setText("accept / " + s + "/" + Thread.currentThread().getName());
                    }
                });
    }

    /**
     * Retrofit2网络请求 线程切换
     */
    public void test3() {
        Observable<GankAndroid> gankAndroid = RetrofitClient.create().getGankAndroid();
        gankAndroid.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankAndroid>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Toast.makeText(MainActivity.this, "START", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(@NonNull GankAndroid gankAndroid) {
                        textView3.setText(gankAndroid.isError() + "");
                        Toast.makeText(MainActivity.this, gankAndroid.isError() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        textView3.setText(e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * Retrofit2网络请求 线程切换 + map
     */
    public void test4() {
        Observable<GankAndroid> gankAndroid = RetrofitClient.create().getGankAndroid();
        gankAndroid.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<GankAndroid, List<GankAndroid.ResultsBean>>() {
                    @Override
                    public List<GankAndroid.ResultsBean> apply(@NonNull GankAndroid gankAndroid) throws Exception {
                        return gankAndroid.getResults();
                    }
                })
                .subscribe(new Observer<List<GankAndroid.ResultsBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Toast.makeText(MainActivity.this, "START", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(@NonNull List<GankAndroid.ResultsBean> resultsBeen) {
                        textView4.setText(resultsBeen.size() + "");
                        Toast.makeText(MainActivity.this, resultsBeen.size() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        textView4.setText(e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * Retrofit2网络请求 线程切换 + zip
     */
    public void test5() {
        Observable<GankAndroid> gankAndroid1 = RetrofitClient.create().getGankAndroid();
        Observable<GankAndroid> gankAndroid2 = RetrofitClient.create().getGankAndroid();
        Observable.zip(gankAndroid1, gankAndroid2, new BiFunction<GankAndroid, GankAndroid, List<GankAndroid.ResultsBean>>() {

            @Override
            public List<GankAndroid.ResultsBean> apply(@NonNull GankAndroid gankAndroid, @NonNull GankAndroid gankAndroid2) throws Exception {
                for (GankAndroid.ResultsBean bean : gankAndroid2.getResults()) {
                    gankAndroid.getResults().add(bean);
                }
                return gankAndroid.getResults();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GankAndroid.ResultsBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Toast.makeText(MainActivity.this, "START", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(@NonNull List<GankAndroid.ResultsBean> resultsBeen) {
                        textView5.setText(resultsBeen.size() + "");
                        Toast.makeText(MainActivity.this, resultsBeen.size() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        textView5.setText(e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    /**
     * Retrofit2网络请求 线程切换 + filter + map
     */
    public void test6() {
        Observable<GankAndroid> gankAndroid = RetrofitClient.create().getGankAndroid();
        gankAndroid.subscribeOn(Schedulers.io())
                .filter(new Predicate<GankAndroid>() {
                    @Override
                    public boolean test(@NonNull GankAndroid gankAndroid) throws Exception {
                        return !gankAndroid.isError();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<GankAndroid, List<GankAndroid.ResultsBean>>() {
                    @Override
                    public List<GankAndroid.ResultsBean> apply(@NonNull GankAndroid gankAndroid) throws Exception {
                        return gankAndroid.getResults();
                    }
                })
                .subscribe(new Observer<List<GankAndroid.ResultsBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Toast.makeText(MainActivity.this, "START", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(@NonNull List<GankAndroid.ResultsBean> resultsBeen) {
                        textView4.setText(resultsBeen.size() + "");
                        Toast.makeText(MainActivity.this, resultsBeen.size() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        textView4.setText(e.getLocalizedMessage());
                        Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
