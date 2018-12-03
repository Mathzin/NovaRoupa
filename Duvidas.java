package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Duvidas {
	
	@SuppressWarnings("resource")
	public void downloadSobreNos() throws IOException {
	    File origem = new File("C:\\Users\\karol\\Documents\\NetBeansProjects\\NovaRoupaDoacoes\\src\\docs\\NovaRoupa-SobreNos.pdf");
	    File destino = new File("C:\\Users\\karol\\Downloads\\NovaRoupa-SobreNos.pdf");
	 if (destino.exists())
	            destino.delete();
	        FileChannel sourceChannel = null;
	        FileChannel destinationChannel = null;
	        try {
	            sourceChannel = new FileInputStream(origem).getChannel();
	            destinationChannel = new FileOutputStream(destino).getChannel();
	            sourceChannel.transferTo(0, sourceChannel.size(),
	                    destinationChannel);
	        } finally {
	            if (sourceChannel != null && sourceChannel.isOpen())
	                sourceChannel.close();
	            if (destinationChannel != null && destinationChannel.isOpen())
	                destinationChannel.close();
	       }
	   
	}
	
	@SuppressWarnings("resource")
	public void downloadPSI() throws IOException {
	    File origem = new File("C:\\Users\\karol\\Documents\\NetBeansProjects\\NovaRoupaDoacoes\\src\\docs\\NovaRoupa-PSI.pdf");
	    File destino = new File("C:\\Users\\karol\\Downloads\\NovaRoupa-PSI.pdf");
	 if (destino.exists())
	            destino.delete();
	        FileChannel sourceChannel = null;
	        FileChannel destinationChannel = null;
	        try {
	            sourceChannel = new FileInputStream(origem).getChannel();
	            destinationChannel = new FileOutputStream(destino).getChannel();
	            sourceChannel.transferTo(0, sourceChannel.size(),
	                    destinationChannel);
	        } finally {
	            if (sourceChannel != null && sourceChannel.isOpen())
	                sourceChannel.close();
	            if (destinationChannel != null && destinationChannel.isOpen())
	                destinationChannel.close();
	       }
	   
	}

}
