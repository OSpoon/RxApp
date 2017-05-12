package com.spoon.top.rxapplication.bean;

import java.util.List;

/**
 * Created by zhanxiaolin-n22 on 2017/5/12.
 */

public class GankAndroid {

    /**
     * error : false
     * results : [{"_id":"5913cd08421aa90c7d49ad80","createdAt":"2017-05-11T10:31:36.254Z","desc":"找到阻碍你 Android App 性能的罪魁祸首！","images":["http://img.gank.io/7bef123d-8055-47de-a1d0-f70e69b9430d"],"publishedAt":"2017-05-11T12:03:09.581Z","source":"chrome","type":"Android","url":"https://github.com/seiginonakama/BlockCanaryEx","used":true,"who":"代码家"},{"_id":"5913cf6e421aa90c7fefdd8b","createdAt":"2017-05-11T10:41:50.51Z","desc":"把音乐的音频提出来，做成音轨。","publishedAt":"2017-05-11T12:03:09.581Z","source":"chrome","type":"Android","url":"https://github.com/akshay2211/MusicWave","used":true,"who":"Allen"},{"_id":"5913cfeb421aa90c7d49ad84","createdAt":"2017-05-11T10:43:55.585Z","desc":"利用 Databinding 来实现自定义字体功能，这个可以有。","images":["http://img.gank.io/1655dcd2-5886-4f0c-b455-8de35b1a3114"],"publishedAt":"2017-05-11T12:03:09.581Z","source":"chrome","type":"Android","url":"https://github.com/EngrAhsanAli/AACustomFont","used":true,"who":"Allen"},{"_id":"59127d59421aa90c7fefdd76","createdAt":"2017-05-10T10:39:21.26Z","desc":"手机上的网页爬虫","images":["http://img.gank.io/373d837c-a136-46f4-8b20-fbbdff48b889"],"publishedAt":"2017-05-10T11:56:10.18Z","source":"web","type":"Android","url":"http://dalingge.com/2017/05/09/%E4%BD%BF%E7%94%A8Jsoup%E6%8A%93%E5%8F%96%E5%B9%B2%E8%B4%A7%E9%9B%86%E4%B8%AD%E8%90%A5%E9%97%B2%E8%AF%BB%E6%95%B0%E6%8D%AE/","used":true,"who":"Max-x"},{"_id":"59101aa9421aa90c7a8b2ade","createdAt":"2017-05-08T15:13:45.831Z","desc":"泡泡效果的索引滚动控件","images":["http://img.gank.io/ca20efbb-7751-4584-adef-c04434448719"],"publishedAt":"2017-05-09T12:13:25.467Z","source":"web","type":"Android","url":"https://github.com/cdflynn/bubble-scroll","used":true,"who":"KNOX"},{"_id":"591091e4421aa90c83a513fe","createdAt":"2017-05-08T23:42:28.112Z","desc":"底部导航tab","images":["http://img.gank.io/2c9ce9b6-135c-4cf0-a50f-a0fb7d31a6c2"],"publishedAt":"2017-05-09T12:13:25.467Z","source":"chrome","type":"Android","url":"https://github.com/bufferapp/AdaptableBottomNavigation","used":true,"who":"Jason"},{"_id":"591108f3421aa90c7a8b2ae4","createdAt":"2017-05-09T08:10:27.504Z","desc":"理解 Android 源码编译命令","publishedAt":"2017-05-09T12:13:25.467Z","source":"chrome","type":"Android","url":"http://gityuan.com/2016/03/19/android-build/","used":true,"who":"Fei"},{"_id":"591139d1421aa90c7d49ad6c","createdAt":"2017-05-09T11:38:57.628Z","desc":"透明屏幕: 装逼利器","images":["http://img.gank.io/6d5fa20e-2ae0-4a02-a9c0-8af75a7cf2ea"],"publishedAt":"2017-05-09T12:13:25.467Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/54e6286a2e73","used":true,"who":null},{"_id":"590d2d00421aa90c83a513e8","createdAt":"2017-05-06T09:55:12.318Z","desc":"自己实现一个超轻量级 JVM ","publishedAt":"2017-05-08T11:22:01.540Z","source":"chrome","type":"Android","url":"https://www.codeproject.com/Articles/24029/Home-Made-Java-Virtual-Machine","used":true,"who":"daimajia"},{"_id":"590ef4c5421aa90c83a513f0","createdAt":"2017-05-07T18:19:49.997Z","desc":"Android SO 文件的兼容和适配","publishedAt":"2017-05-08T11:22:01.540Z","source":"web","type":"Android","url":"http://blog.coderclock.com/2017/05/07/android/Android-so-files-compatibility-and-adaptation/","used":true,"who":"D_clock"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5913cd08421aa90c7d49ad80
         * createdAt : 2017-05-11T10:31:36.254Z
         * desc : 找到阻碍你 Android App 性能的罪魁祸首！
         * images : ["http://img.gank.io/7bef123d-8055-47de-a1d0-f70e69b9430d"]
         * publishedAt : 2017-05-11T12:03:09.581Z
         * source : chrome
         * type : Android
         * url : https://github.com/seiginonakama/BlockCanaryEx
         * used : true
         * who : 代码家
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
