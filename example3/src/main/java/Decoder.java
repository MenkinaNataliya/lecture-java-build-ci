package lab6_decoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decoder {
	
	public static String EncoderString(String str) throws IOException{
		byte[] buf = new byte[100];

        ByteArrayInputStream bin = new ByteArrayInputStream(Base64.decodeBase64(str));
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bin);
        xzIn.read(buf);
        xzIn.close();
        String result = new String(buf);
        
       return result;
	}
/*
Enter String: *****
/Td6WFoAAATm1rRGAgAhARYAAAB0L+WjAQBEQXBhY2hlIE1hdmVuIGlzIGEgc29mdHdhcmUgcHJvamVjdCBtYW5hZ2VtZW50IGFuZCBjb21wcmVoZW5zaW9uIHRvb2wuAAAAAMXaU7TVffeMAAFdRS0jJSkftvN9AQAAAAAEWVo=
*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        String s = br.readLine();

        System.out.println(EncoderString(s));
    }
}