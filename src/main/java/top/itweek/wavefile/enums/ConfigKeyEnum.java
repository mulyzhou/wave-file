package top.itweek.wavefile.enums;


public enum ConfigKeyEnum {

    /**
     * 系统最后一次更新的日期
     */
    UPDATE_TIME("updateTime"),
    /**
     * 存储类型
     */
    STORAGE_TYPE("storageType"),
    /**
     * 文件服务器域名
     */
    LOCAL_FILE_URL("localFileUrl"),
    /**
     * 文件存储路径
     */
    LOCAL_FILE_PATH("localFilePath"),
    /**
     * 七牛云Bucket 名称
     */
    QINIU_BUCKET_NAME("qiniuBucketName"),
    /**
     * 七牛云AccessKey
     */
    QINIU_ACCESS_KEY("qiniuAccessKey"),
    /**
     * 七牛云Secret Key
     */
    QINIU_SECRET_KEY("qiniuSecretKey"),
    /**
     * 七牛云cdn域名
     */
    QINIU_BASE_PATH("qiniuBasePath"),
    /**
     * 阿里云Bucket 名称
     */
    ALIYUN_BUCKET_NAME("aliyunBucketName"),
    /**
     * 阿里云地域节点（EndPoint）
     */
    ALIYUN_ENDPOINT("aliyunEndpoint"),
    /**
     * 阿里云Bucket 域名
     */
    ALIYUN_FILE_URL("aliyunFileUrl"),
    /**
     * 阿里云Access Key
     */
    ALIYUN_ACCESS_KEY("aliyunAccessKey"),
    /**
     * 阿里云Access Key Secret
     */
    ALIYUN_ACCESS_KEY_SECRET("aliyunAccessKeySecret"),

    ;

    private String key;

    ConfigKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }}
