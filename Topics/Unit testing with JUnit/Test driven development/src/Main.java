class Person {

    // Do not change these fields
    public static final String DEFAULT_NAME = "Unknown";
    public static final int MAX_AGE = 130;
    public static final int MIN_AGE = 0;
    private final String name;
    private final int age;

    Person(String name, int age) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }

        this.age = clamp(age, MIN_AGE, MAX_AGE);
    }

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
