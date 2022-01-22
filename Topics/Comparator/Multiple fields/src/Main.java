import java.util.Comparator;
import java.util.List;

class User {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    private static final NameAgeComparator nameAgeComparator = new NameAgeComparator();

    public static void sortUsers(List<User> users) {
        users.sort(nameAgeComparator);
    }

    private static class NameAgeComparator implements Comparator<User> {

        private final Comparator<User> nameComparator = new NameComparator();
        private final Comparator<User> ageComparator = new AgeComparator();

        @Override
        public int compare(User user1, User user2) {
            int nameComparison = nameComparator.compare(user1, user2);

            if (nameComparison == 0) {
                // If names are same, sort by descending age.
                return ageComparator.reversed().compare(user1, user2);
            } else {
                return nameComparison;
            }
        }
    }

    private static class NameComparator implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return user1.getName().compareTo(user2.getName());
        }
    }

    private static class AgeComparator implements Comparator<User> {

        @Override
        public int compare(User user1, User user2) {
            return Integer.compare(user1.getAge(), user2.getAge());
        }
    }
}
