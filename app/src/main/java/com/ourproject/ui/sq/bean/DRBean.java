package com.ourproject.ui.sq.bean;

/**
 * Created by admin on 2017/4/11.
 */

public class DRBean {
    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1491902287000
     * data : {"user_id":1842643,"nickname":"掌厨彭莎","headphoto":"http://tva1.sinaimg.cn/crop.0.5.750.750.180/9f483da8jw8fbjnhv45wcj20ku0l5gms.jpg","gender":2,"user_tag":",,","region_id":"","areaid":0,"declaration":"新浪微博账号：掌厨彭莎Lisa","istalent":1,"background":"http://img.szzhangchu.com/1488887269512_5510517055.jpg","year":"19960722","taste":"","like":"","effect":"","province":"20","baidu_province":"广东省","baidu_city":"深圳市","address":"","tongji_message":0,"tongji_collect":0,"tongji_be_follow":2913,"tongji_follow":0,"tongji_post":10,"token":""}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 1842643
         * nickname : 掌厨彭莎
         * headphoto : http://tva1.sinaimg.cn/crop.0.5.750.750.180/9f483da8jw8fbjnhv45wcj20ku0l5gms.jpg
         * gender : 2
         * user_tag : ,,
         * region_id :
         * areaid : 0
         * declaration : 新浪微博账号：掌厨彭莎Lisa
         * istalent : 1
         * background : http://img.szzhangchu.com/1488887269512_5510517055.jpg
         * year : 19960722
         * taste :
         * like :
         * effect :
         * province : 20
         * baidu_province : 广东省
         * baidu_city : 深圳市
         * address :
         * tongji_message : 0
         * tongji_collect : 0
         * tongji_be_follow : 2913
         * tongji_follow : 0
         * tongji_post : 10
         * token :
         */

        private int user_id;
        private String nickname;
        private String headphoto;
        private int gender;
        private String user_tag;
        private String region_id;
        private int areaid;
        private String declaration;
        private int istalent;
        private String background;
        private String year;
        private String taste;
        private String like;
        private String effect;
        private String province;
        private String baidu_province;
        private String baidu_city;
        private String address;
        private int tongji_message;
        private int tongji_collect;
        private int tongji_be_follow;
        private int tongji_follow;
        private int tongji_post;
        private String token;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadphoto() {
            return headphoto;
        }

        public void setHeadphoto(String headphoto) {
            this.headphoto = headphoto;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getUser_tag() {
            return user_tag;
        }

        public void setUser_tag(String user_tag) {
            this.user_tag = user_tag;
        }

        public String getRegion_id() {
            return region_id;
        }

        public void setRegion_id(String region_id) {
            this.region_id = region_id;
        }

        public int getAreaid() {
            return areaid;
        }

        public void setAreaid(int areaid) {
            this.areaid = areaid;
        }

        public String getDeclaration() {
            return declaration;
        }

        public void setDeclaration(String declaration) {
            this.declaration = declaration;
        }

        public int getIstalent() {
            return istalent;
        }

        public void setIstalent(int istalent) {
            this.istalent = istalent;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getTaste() {
            return taste;
        }

        public void setTaste(String taste) {
            this.taste = taste;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getBaidu_province() {
            return baidu_province;
        }

        public void setBaidu_province(String baidu_province) {
            this.baidu_province = baidu_province;
        }

        public String getBaidu_city() {
            return baidu_city;
        }

        public void setBaidu_city(String baidu_city) {
            this.baidu_city = baidu_city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getTongji_message() {
            return tongji_message;
        }

        public void setTongji_message(int tongji_message) {
            this.tongji_message = tongji_message;
        }

        public int getTongji_collect() {
            return tongji_collect;
        }

        public void setTongji_collect(int tongji_collect) {
            this.tongji_collect = tongji_collect;
        }

        public int getTongji_be_follow() {
            return tongji_be_follow;
        }

        public void setTongji_be_follow(int tongji_be_follow) {
            this.tongji_be_follow = tongji_be_follow;
        }

        public int getTongji_follow() {
            return tongji_follow;
        }

        public void setTongji_follow(int tongji_follow) {
            this.tongji_follow = tongji_follow;
        }

        public int getTongji_post() {
            return tongji_post;
        }

        public void setTongji_post(int tongji_post) {
            this.tongji_post = tongji_post;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
