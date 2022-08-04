public class Main {
    private final static String CIPHERED_MESSAGE = "\u043A\u0463\u0008\u0419\u0463\u0413\u0410\u0008\u041A\u0463\u0419\u0468\u0418\u0415\u0463\u0008\u041C\u0413\u0467\u0008\u0417\u0468\u0416\u046D\u0416\u041E\u041C\u041D\u0415\u0410\u0467\u0008\u0469\u0416\u0419\u041D\u0469\u041D\u041C\u0416\u041A\u0418\u0415\u0410\u0467\u0006\u0008\u0437\u0468\u0410\u0469\u0463\u0413\u0418\u0411\u046A\u041D\u0008\u0469\u041A\u0416\u0479\u0008\u0468\u041D\u041F\u0466\u0414\u041D\u0008\u0415\u0418\u0008\u005B";

    private static class Cipher {
        private final String cipheredMessage;

        public Cipher(String cipheredMessage) {
            this.cipheredMessage = cipheredMessage;
        }

        public String uncipher(int secret) {
            return this.cipheredMessage
                    .codePoints()
                    .map(i -> i ^ secret)
                    .collect(
                            StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append
                    )
                    .toString();
        }
    }

    private static int findFirstBitIndex(long n) {
        int result = 0;
        while (n > 0) {
            n >>= 1;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        //птички напели, что ключ шифрования — индекс старшего бита текущего таймстемпа
        var time = System.currentTimeMillis();
        var secret = findFirstBitIndex(time);
        var deciphered = new Cipher(CIPHERED_MESSAGE).uncipher(secret);
        System.out.println("Please follow these instructions:");
        System.out.println(deciphered);
    }
}
