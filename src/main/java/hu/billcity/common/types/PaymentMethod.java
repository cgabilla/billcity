package hu.billcity.common.types;

/**
 * hu.billcity.common
 * <p/>
 * <Class Description>
 * <p/>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 6:20 AM; 3/5/2016
 * @since 1.8
 */

public class PaymentMethod {
    public static final PaymentMethod DEFAULT = new PaymentMethod(Type.OTHER_METHODS, false);
    protected Type type;
    protected boolean isMandatory;

    public PaymentMethod(PaymentMethod.Type type, boolean isMandatory) {
        this.type = type;
        this.isMandatory = isMandatory;
    }

    public Type getPaymentMethodType() {
        return type;
    }


    public void setPaymentMethodType(PaymentMethod.Type type) {
        if (!isMandatory)
            this.type = type;
    }


    public boolean isMandatory() {
        return isMandatory;
    }


    public void setMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append("PaymentMethod{")
                .append("type=").append(type)
                .append(", isMandatory=").append(isMandatory)
                .append('}').toString();
    }

    public enum Type {
        CASH(0), PAYPAL(1), TRANSFER_WISE(2), CREDIT_CARD(3), BANK_TRANSFER(4), OTHER_METHODS(7);

        private int value;

        Type(int value) {
            this.value = value;
        }

    }
}
