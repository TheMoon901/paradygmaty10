import java.util.List;

public interface Singleton {
    default void removeAnotherSingleton(List<Item> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof ComplexItem) {
                removeAnotherSingleton(((ComplexItem)list.get(i)).getChildren());
            }

            if(list.get(i) instanceof Singleton && !((Singleton)list.get(i)).equals(this)) {
                list.remove(i);
            }
        }
    }
}
