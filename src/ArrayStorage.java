import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int sizeOfArray = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < sizeOfArray; i++) {
            storage[i] = null;
        }
        sizeOfArray = 0;
    }

    void save(Resume r) {
        storage[sizeOfArray] = r;
        sizeOfArray++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                sizeOfArray--;
            }
        }
        boolean check = true;
        while (check && (index != -1)) {
            if (storage[index + 1] != null) {
                storage[index] = storage[index + 1];
                storage[index + 1] = null;
                index++;
            } else {
                check = false;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, sizeOfArray);
    }

    int size() {
        return sizeOfArray;
    }
}
