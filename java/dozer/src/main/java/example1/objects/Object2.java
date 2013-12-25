package example1.objects;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dmitriy.kurkin
 */
public class Object2 {

    private String string1;
    private String string2;
    private Integer integer;

    public Object2() {}

    public Object2(String string1, String string2, Integer integer) {
        this.string1 = string1;
        this.string2 = string2;
        this.integer = integer;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("string1", string1)
                .append("string2", string2)
                .append("integer", integer)
                .build();
    }

}
