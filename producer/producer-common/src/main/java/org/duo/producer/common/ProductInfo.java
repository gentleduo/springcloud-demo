package org.duo.producer.common;

public class ProductInfo {

    private int id;
    private String name;
    private String describe;

    public ProductInfo(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", describe='").append(describe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
