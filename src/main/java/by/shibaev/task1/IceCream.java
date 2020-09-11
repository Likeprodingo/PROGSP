package by.shibaev.task1;

public class IceCream {
    private boolean chocolate;
    private String name;
    private float richness;

    public IceCream() {
    }

    public IceCream(String name, float richness) {
        chocolate = false;
        this.name = name;
        this.richness = richness;
    }

    public IceCream(boolean chocolate, String name, float richness) {
        this.chocolate = chocolate;
        this.name = name;
        this.richness = richness;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRichness() {
        return richness;
    }

    public void setRichness(float richness) {
        this.richness = richness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IceCream iceCream = (IceCream) o;

        if (chocolate != iceCream.chocolate) return false;
        if (Float.compare(iceCream.richness, richness) != 0) return false;
        return name != null ? name.equals(iceCream.name) : iceCream.name == null;
    }

    @Override
    public int hashCode() {
        int result = (chocolate ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (richness != +0.0f ? Float.floatToIntBits(richness) : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IceCream{");
        sb.append("chocolate=").append(chocolate);
        sb.append(", name='").append(name).append('\'');
        sb.append(", richness=").append(richness);
        sb.append('}');
        return sb.toString();
    }
}
