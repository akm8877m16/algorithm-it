/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm;

/**
 *
 * @author wb-ywh474663
 * @version $Id: HanoiTowerStackOperationEnum.java, v 0.1 2018年11月25日 22:45 wb-ywh474663 Exp $
 */
public enum HanoiTowerStackOperationEnum {
    LEFT_TO_MIDDLE(1,"left to middle"),
    MIDDLE_TO_LEFT(2,"middle to left"),
    RIGHT_TO_MIDDLE(3,"right to middle"),
    MIDDLE_TO_RIGHT(4,"middle to right"),
    ;

    /** 操作类型 */
    private int code;

    /** 操作描述 */
    private String operationDesc;

    private HanoiTowerStackOperationEnum(int code, String operationDesc){
        this.code = code;
        this.operationDesc = operationDesc;
    }

    public static HanoiTowerStackOperationEnum getByCode(int code) {
        for (HanoiTowerStackOperationEnum action : values()) {
            if (action.getCode() == code) {
                return action;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>operationDesc</tt>.
     *
     * @return property value of operationDesc
     */
    public String getOperationDesc() {
        return operationDesc;
    }

    /**
     * Setter method for property <tt>operationDesc</tt>.
     *
     * @param operationDesc value to be assigned to property operationDesc
     */
    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }
}