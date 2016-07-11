import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

//import com.ibm.icu.charset.CharsetICU;
public class ReadBinary {

	    public static void main(String [] args) {

	        // The name of the file to open.
	        String fileName = "C:\\Users\\IBM_ADMIN\\Downloads\\sqlite-shell-win32-x86-3080403\\20150101010306.pmsdata.txt";

	        try {
	            // Use this for reading the data.
	            byte[] buffer = new byte[1000];

	            FileInputStream inputStream = 
	                new FileInputStream(fileName);
	            String s = null, encoding, cannonicalCharsetName;
	            // read fills buffer with data and returns
	            // the number of bytes read (which of course
	            // may be less than the buffer size, but
	            // it will never be more).
	            int total = 0;
	            int nRead = 0;
	            while((nRead = inputStream.read(buffer)) != -1) {
	                // Convert to String so we can display it.
	                // Of course you wouldn't want to do this with
	                // a 'real' binary file.
	                System.out.println(new String(buffer,"US-ASCII"));
	                total += nRead;
	            }   

	         /*   Charset charset = CharsetICU.forName(encoding);
	            CharsetDecoder decoder = charset.newDecoder();
	            cannonicalCharsetName = charset.name();

	            // replace unknown characters with "replace"
	            decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
	            decoder.onMalformedInput(CodingErrorAction.REPLACE);
	            decoder.replaceWith("?");
	            ByteBuffer bbuf = ByteBuffer.wrap(buffer);
	            CharBuffer charBuffer = CharBuffer.allocate(3*bbuf.capacity());
	            CoderResult cr = null;

	            try {
	                // decode bbuf into charBuffer
	                cr = decoder.decode(bbuf, charBuffer, true);
	                if (cr.isUnderflow())
	                {
	                    decoder.flush(charBuffer);
	                }
	                // set charBuffer limit to curent position, and then set current position to 0 
	                int current_buff_position = charBuffer.position();
	                charBuffer.limit(current_buff_position).position(0);

	                // set s
	                s = charBuffer.toString();
	            }
	            catch(Exception e)
	            {
	                
	                System.exit(1);
	            }
	            System.out.println(s);
	            // Always close files.
	          */  inputStream.close();       

	            System.out.println("Read " + total + " bytes");
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");               
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                   
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	    }
	}
