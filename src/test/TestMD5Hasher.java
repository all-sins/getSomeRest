import com.codemonkeys.getSomeRest.controller.Utilities;
import org.junit.Test;
import org.junit.Assert;

public class TestMD5Hasher {

    private Utilities utilities = new Utilities();
    private Utilities utilities2 = new Utilities();

    @Test
    public void testMD5Hasher_sameStringSameHasher() {

//        String salt = String.valueOf(System.currentTimeMillis());
//        List<String> passwords = Arrays.asList("123456", "123456789", "picture1", "password", "12345678", "111111", "123123", "12345", "1234567890", "admin");
//        List<String> saltedPasswords = new ArrayList<>();
//        for (String password : passwords) {
//            saltedPasswords.add(password+salt);
//        }
//        List<String> hashedSaltedPasswords = new ArrayList<>();
//        for (String saltedPassword : saltedPasswords) {
//            hashedSaltedPasswords.add(utilities.getMD5Hash(saltedPassword).getHash());
//        }
//
//        for (int i = 0; i < saltedPasswords.size(); i++) {
//            org.junit.Assert.assertEquals(hashedSaltedPasswords.get(i), utilities.getMD5Hash(saltedPasswords.get(i)).getHash());
//        }
//        System.out.println("Passed with the same hasher!");
//
//        for (int i = 0; i < saltedPasswords.size(); i++) {
//            org.junit.Assert.assertEquals(hashedSaltedPasswords.get(i), utilities2.getMD5Hash(saltedPasswords.get(i)).getHash());
//        }

        Assert.assertEquals(utilities.getMD5Hash("admin").getHash(), utilities.getMD5Hash("admin").getHash());

    }

    @Test
    public void testMD5Hasher_differentStringSameHasher() {
        Assert.assertFalse(utilities.getMD5Hash("admin").getHash().equals(utilities.getMD5Hash("yeet").getHash()));
    }

    @Test
    public void testMD5Hasher_sameStringdifferentHasher() {
        Assert.assertEquals(utilities.getMD5Hash("admin").getHash(), utilities2.getMD5Hash("admin").getHash());
    }

    @Test
    public void testMD5Hasher_differentStringDifferentHasher() {
        Assert.assertFalse(utilities.getMD5Hash("admin").getHash().equals(utilities2.getMD5Hash("yeet").getHash()));
    }

}
