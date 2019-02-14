package com.example.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BIZ_STORE_LABEL")
public class BizStoreLabel implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "N_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 标签内容
     */
    @Column(name = "LABEL_CONTEXT")
    private String labelContext;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return N_ID - 自增ID
     */
    public Integer getnId() {
        return nId;
    }

    /**
     * 设置自增ID
     *
     * @param nId 自增ID
     */
    public void setnId(Integer nId) {
        this.nId = nId;
    }

    /**
     * 获取标签内容
     *
     * @return LABEL_CONTEXT - 标签内容
     */
    public String getLabelContext() {
        return labelContext;
    }

    /**
     * 设置标签内容
     *
     * @param labelContext 标签内容
     */
    public void setLabelContext(String labelContext) {
        this.labelContext = labelContext == null ? null : labelContext.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_USER - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nId=").append(nId);
        sb.append(", labelContext=").append(labelContext);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}