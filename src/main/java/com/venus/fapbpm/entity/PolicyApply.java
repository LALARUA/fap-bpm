package com.venus.fapbpm.entity;

import com.venus.fapbpm.definedAnnotation.DBFieldExplain;

import javax.persistence.*;

@Table(name = "test.policy_apply")
public class PolicyApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 申请用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 新增、删除、修改、移动
     */
    @DBFieldExplain(value = "类型")
    private String type;

    /**
     * 防火墙id
     */
    @Column(name = "firewall_id")
    private Integer firewallId;

    /**
     * 防火墙名称
     */
    @DBFieldExplain(value = "防火墙")
    @Column(name = "firewall_name")
    private String firewallName;

    /**
     * 策略集id
     */
    @Column(name = "policy_set_id")
    private Integer policySetId;

    /**
     * 策略集名称
     */
    @DBFieldExplain(value = "策略集")
    @Column(name = "policy_set_name")
    private String policySetName;

    /**
     * 策略id
     */
    @Column(name = "policy_id")
    private Integer policyId;

    /**
     * 策略名称
     */
    @DBFieldExplain(value = "策略名称")
    @Column(name = "policy_name")
    private String policyName;

    /**
     * 源域名称
     */
    @DBFieldExplain(value = "源域")
    @Column(name = "src_zone_name")
    private String srcZoneName;

    /**
     * 目的域名称
     */
    @DBFieldExplain(value = "目的域")
    @Column(name = "dst_zone_name")
    private String dstZoneName;

    /**
     * 源地址名称
     */
    @DBFieldExplain(value = "源地址名称")
    @Column(name = "src_address_name")
    private String srcAddressName;

    /**
     * 源地址内容
     */
    @DBFieldExplain(value = "源地址内容")
    @Column(name = "src_address_content")
    private String srcAddressContent;

    /**
     * 目的地址名称
     */
    @DBFieldExplain(value = "目的地址名称")
    @Column(name = "dst_address_name")
    private String dstAddressName;

    /**
     * 目的地址内容
     */
    @DBFieldExplain(value = "目的地址内容")
    @Column(name = "dst_address_content")
    private String dstAddressContent;

    /**
     * 时间对象名称
     */
    @DBFieldExplain(value = "时间名称")
    @Column(name = "time_name")
    private String timeName;

    /**
     * 时间内容
     */
    @DBFieldExplain(value = "时间内容")
    @Column(name = "time_content")
    private String timeContent;

    /**
     * 服务名称
     */
    @DBFieldExplain(value = "服务名称")
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 服务内容
     */
    @DBFieldExplain(value = "服务内容")
    @Column(name = "service_content")
    private String serviceContent;

    /**
     * permit or deny
     */
    @DBFieldExplain(value = "动作")
    private String action;

    /**
     * 日志是否启用，0-未启用，1-启用
     */
    @DBFieldExplain(value = "日志启用")
    @Column(name = "enable_log")
    private Integer enableLog;

    /**
     * 基线，0-是，1-不是
     */
    @DBFieldExplain(value = "基线启用")
    @Column(name = "enable_baseline")
    private Integer enableBaseline;

    /**
     * 移动详情
     */
    @DBFieldExplain(value = "移动详情")
    private String move;

    /**
     * 备注
     */
    @DBFieldExplain(value = "备注")
    private String remarks;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 申请详情
     */
    private String detail;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取申请用户id
     *
     * @return user_id - 申请用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置申请用户id
     *
     * @param userId 申请用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取新增、删除、修改、移动
     *
     * @return type - 新增、删除、修改、移动
     */
    public String getType() {
        return type;
    }

    /**
     * 设置新增、删除、修改、移动
     *
     * @param type 新增、删除、修改、移动
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取防火墙id
     *
     * @return firewall_id - 防火墙id
     */
    public Integer getFirewallId() {
        return firewallId;
    }

    /**
     * 设置防火墙id
     *
     * @param firewallId 防火墙id
     */
    public void setFirewallId(Integer firewallId) {
        this.firewallId = firewallId;
    }

    /**
     * 获取防火墙名称
     *
     * @return firewall_name - 防火墙名称
     */
    public String getFirewallName() {
        return firewallName;
    }

    /**
     * 设置防火墙名称
     *
     * @param firewallName 防火墙名称
     */
    public void setFirewallName(String firewallName) {
        this.firewallName = firewallName;
    }

    /**
     * 获取策略集id
     *
     * @return policy_set_id - 策略集id
     */
    public Integer getPolicySetId() {
        return policySetId;
    }

    /**
     * 设置策略集id
     *
     * @param policySetId 策略集id
     */
    public void setPolicySetId(Integer policySetId) {
        this.policySetId = policySetId;
    }

    /**
     * 获取策略集名称
     *
     * @return policy_set_name - 策略集名称
     */
    public String getPolicySetName() {
        return policySetName;
    }

    /**
     * 设置策略集名称
     *
     * @param policySetName 策略集名称
     */
    public void setPolicySetName(String policySetName) {
        this.policySetName = policySetName;
    }

    /**
     * 获取策略id
     *
     * @return policy_id - 策略id
     */
    public Integer getPolicyId() {
        return policyId;
    }

    /**
     * 设置策略id
     *
     * @param policyId 策略id
     */
    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    /**
     * 获取策略名称
     *
     * @return policy_name - 策略名称
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * 设置策略名称
     *
     * @param policyName 策略名称
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * 获取源域名称
     *
     * @return src_zone_name - 源域名称
     */
    public String getSrcZoneName() {
        return srcZoneName;
    }

    /**
     * 设置源域名称
     *
     * @param srcZoneName 源域名称
     */
    public void setSrcZoneName(String srcZoneName) {
        this.srcZoneName = srcZoneName;
    }

    /**
     * 获取目的域名称
     *
     * @return dst_zone_name - 目的域名称
     */
    public String getDstZoneName() {
        return dstZoneName;
    }

    /**
     * 设置目的域名称
     *
     * @param dstZoneName 目的域名称
     */
    public void setDstZoneName(String dstZoneName) {
        this.dstZoneName = dstZoneName;
    }

    /**
     * 获取源地址名称
     *
     * @return src_address_name - 源地址名称
     */
    public String getSrcAddressName() {
        return srcAddressName;
    }

    /**
     * 设置源地址名称
     *
     * @param srcAddressName 源地址名称
     */
    public void setSrcAddressName(String srcAddressName) {
        this.srcAddressName = srcAddressName;
    }

    /**
     * 获取目的地址名称
     *
     * @return dst_address_name - 目的地址名称
     */
    public String getDstAddressName() {
        return dstAddressName;
    }

    /**
     * 设置目的地址名称
     *
     * @param dstAddressName 目的地址名称
     */
    public void setDstAddressName(String dstAddressName) {
        this.dstAddressName = dstAddressName;
    }

    /**
     * 获取源地址内容
     *
     * @return src_address_content - 源地址内容
     */
    public String getSrcAddressContent() {
        return srcAddressContent;
    }

    /**
     * 设置源地址内容
     *
     * @param srcAddressContent 源地址内容
     */
    public void setSrcAddressContent(String srcAddressContent) {
        this.srcAddressContent = srcAddressContent;
    }

    /**
     * 获取目的地址内容
     *
     * @return dst_address_content - 目的地址内容
     */
    public String getDstAddressContent() {
        return dstAddressContent;
    }

    /**
     * 设置目的地址内容
     *
     * @param dstAddressContent 目的地址内容
     */
    public void setDstAddressContent(String dstAddressContent) {
        this.dstAddressContent = dstAddressContent;
    }

    /**
     * 获取时间对象名称
     *
     * @return time_name - 时间对象名称
     */
    public String getTimeName() {
        return timeName;
    }

    /**
     * 设置时间对象名称
     *
     * @param timeName 时间对象名称
     */
    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    /**
     * 获取时间内容
     *
     * @return time_content - 时间内容
     */
    public String getTimeContent() {
        return timeContent;
    }

    /**
     * 设置时间内容
     *
     * @param timeContent 时间内容
     */
    public void setTimeContent(String timeContent) {
        this.timeContent = timeContent;
    }

    /**
     * 获取服务名称
     *
     * @return service_name - 服务名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置服务名称
     *
     * @param serviceName 服务名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 获取服务内容
     *
     * @return service_content - 服务内容
     */
    public String getServiceContent() {
        return serviceContent;
    }

    /**
     * 设置服务内容
     *
     * @param serviceContent 服务内容
     */
    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    /**
     * 获取permit or deny
     *
     * @return action - permit or deny
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置permit or deny
     *
     * @param action permit or deny
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取日志是否启用，0-未启用，1-启用
     *
     * @return enable_log - 日志是否启用，0-未启用，1-启用
     */
    public Integer getEnableLog() {
        return enableLog;
    }

    /**
     * 设置日志是否启用，0-未启用，1-启用
     *
     * @param enableLog 日志是否启用，0-未启用，1-启用
     */
    public void setEnableLog(Integer enableLog) {
        this.enableLog = enableLog;
    }

    /**
     * 获取基线，0-是，1-不是
     *
     * @return enable_baseline - 基线，0-是，1-不是
     */
    public Integer getEnableBaseline() {
        return enableBaseline;
    }

    /**
     * 设置基线，0-是，1-不是
     *
     * @param enableBaseline 基线，0-是，1-不是
     */
    public void setEnableBaseline(Integer enableBaseline) {
        this.enableBaseline = enableBaseline;
    }

    /**
     * 获取移动详情
     *
     * @return move - 移动详情
     */
    public String getMove() {
        return move;
    }

    /**
     * 设置移动详情
     *
     * @param move 移动详情
     */
    public void setMove(String move) {
        this.move = move;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取申请详情
     *
     * @return detail - 申请详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置申请详情
     *
     * @param detail 申请详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}