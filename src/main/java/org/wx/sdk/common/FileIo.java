package org.wx.sdk.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * 文件操作类
 * @author Rocye
 * @version 2017.02.28
 */
public class FileIo {
	private final static Logger logger = Logger.getLogger(FileIo.class.getName());
    
	/**
	 * 写文本文件内容
	 * @author Rocye
	 * @param filePathAndName 文本文件完整绝对路径及文件名
	 * @param fileContent 文本文件内容
	 * @param encoding 编码方式 例如 GBK 或者 UTF-8
	 * @return 文本文件完整绝对路径及文件名 或 null
	 * @version 2017.02.28
	 */
	public static String writeText(String filePathAndName, String fileContent, String encoding) {
		if (encoding == null || encoding.equals("")){
			encoding = "UTF-8";
		}
		try {
			FileUtils.write(new File(filePathAndName), fileContent, encoding);
			return filePathAndName;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon包写文本文件时：" + e.toString());
			return null;
		}
	}

	/**
	 * 追加写文本文件内容
	 * @author Rocye
	 * @param filePathAndName 文本文件完整绝对路径及文件名
	 * @param fileContent 文本文件内容
	 * @param encoding 编码方式 例如 GBK 或者 UTF-8 默认UTF-8
	 * @return 文本文件完整绝对路径及文件名 或 null
	 * @version 2017.02.28
	 */
	public static String appendWriteText(String filePathAndName, String fileContent, String encoding) {
		if (encoding == null || encoding.equals("")){
			encoding = "UTF-8";
		}
		try {
			FileUtils.write(new File(filePathAndName), fileContent, encoding, true);
			return filePathAndName;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon包追加写文本文件时：" + e.toString());
			return null;
		}
	}

	/**
	 * 读取文本文件内容
	 * @author Rocye
	 * @param filePathAndName 带有完整绝对路径的文件名
	 * @param encoding 文本文件打开的编码方式 GBK UTF-8
	 * @return 返回文本文件的内容
	 * @version 2017.02.28
	 */
	public static String readText(String filePathAndName, String encoding) {
		if (encoding == null || encoding.equals("")){
			encoding = "UTF-8";
		}
		try {
			String fileContent = FileUtils.readFileToString(new File(filePathAndName), encoding);
			return fileContent;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon读文本文件时：" + e.toString());
			return null;
		}
	}

	/**
	 * 写二进制流到文件
	 * @param inputStream 二进制流
	 * @param filePathAndName 保存的文件
	 * @param append 是否追加写入
	 * @return 保存的文件名
	 * @version 2017.02.28
	 */
	public static String writeFile(InputStream inputStream, String filePathAndName, boolean append) {
		OutputStream out = null;
		String fileName = null;
        try {
        	File file = new File(filePathAndName);
        	fileName = file.getName();
            out = FileUtils.openOutputStream(file, append);
            byte[] buffer = new byte[1024 * 5];
			int byteread = 0;
			while ((byteread = inputStream.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
            out.close();
        }catch(IOException e){
        	e.printStackTrace();
        	logger.error("调用ApacheCommon写二进制流到指定文件时：" + e.toString());
        }finally {
            if(out != null) {
            	try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
		return fileName;
	}
	
	/**
	 * 写二进制流到文件
	 * @param inputStream 二进制流
	 * @param filePathAndName 保存的文件
	 * @return 保存的文件名
	 */
	public static String writeFile(InputStream inputStream, String filePathAndName){
		return writeFile(inputStream, filePathAndName, false);
	}

	/**
	 * 写二进制数据到文件
	 * @param data 二进制数组
	 * @param filePathAndName 保存的文件
	 * @param append 是否追加写入
	 * @return 保存的文件名
	 * @version 2017.02.28
	 */
	public static String writeFile(byte[] data, String filePathAndName, boolean append) {
		String fileName = null;
		try {
			File file = new File(filePathAndName);
			fileName = file.getName();
			FileUtils.writeByteArrayToFile(file, data, append);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon写二进制数据到指定文件时：" + e.toString());
		}
		return fileName;
	}
	
	/**
	 * 写二进制数据到文件
	 * @param data 二进制数据
	 * @param filePathAndName 保存的文件
	 * @return 保存的文件名
	 * @version 2017.02.28
	 */
	public static String writeFile(byte[] data, String filePathAndName){
		return writeFile(data, filePathAndName, false);
	}

	/**
	 * 读取二进制文件
	 * @param filePathAndName 带有完整绝对路径的文件名
	 * @return 二进制数据
	 * @version 2017.02.28
	 */
	public static byte[] readFile(String filePathAndName) {
		byte[] byteA = null;
		try {
			byteA = FileUtils.readFileToByteArray(new File(filePathAndName));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon读二进制数据时：" + e.toString());
		}
		return byteA;
	}

	/**
	 * 多级目录创建
	 * @author Rocye
	 * @param multiFolderPath 要创建的目录路径
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean createFolders(String multiFolderPath) {
		try {
			FileUtils.forceMkdir(new File(multiFolderPath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon创建多级目录时：" + e.toString());
			return false;
		}
	}

	/**
	 * 新建目录
	 * @author Rocye
	 * @param folderPath 目录
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean createFolder(String folderPath) {
		try {
			FileUtils.forceMkdir(new File(folderPath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon创建单级目录时：" + e.toString());
			return false;
		}
	}

	/**
	 * 删除文件
	 * @author Rocye
	 * @param filePathAndName 文本文件完整绝对路径及文件名
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean deleteFile(String filePathAndName) {
		FileUtils.deleteQuietly(new File(filePathAndName));
		return true;
	}

	/**
	 * 删除指定文件夹下所有文件
	 * @author Rocye
	 * @param folderPath 文件夹完整绝对路径
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean deleteAllFile(String folderPath) {
		try {
			FileUtils.cleanDirectory(new File(folderPath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon清空指定目录时：" + e.toString());
			return false;
		}
	}

	/**
	 * 删除文件夹
	 * @author Rocye
	 * @param folderPath 文件夹完整绝对路径
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean deleteFolder(String folderPath) {
		try {
			FileUtils.deleteDirectory(new File(folderPath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon删除指定目录时：" + e.toString());
			return false;
		}
	}

	/**
	 * 复制单个文件
	 * @author Rocye
	 * @param srcFilePath 	复制的源文件路径
	 * @param destFilePath 	复制的目标文件路径
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean copyFile(String srcFilePath, String destFilePath) {
		try {
			FileUtils.copyFile(new File(srcFilePath), new File(destFilePath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon复制文件时：" + e.toString());
			return false;
		}
	}

	/**
	 * 复制目录
	 * @author Rocye
	 * @param srcPath 	复制的源文件夹路径
	 * @param destPath 	复制的目标文件夹路径
	 * @param isCopyRoot 是否复制根目录 true为复制根目录 false为不复制根目录，只复制根目录下的所有文件以及文件夹
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean copyFolder(String srcPath, String destPath, boolean isCopyRoot) {
		try {
			if(isCopyRoot){
				FileUtils.copyDirectoryToDirectory(new File(srcPath), new File(destPath));
			}else{
				FileUtils.copyDirectory(new File(srcPath), new File(destPath));
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon复制文件夹时：" + e.toString());
			return false;
		}
	}

	/**
	 * 移动文件
	 * @author Rocye
	 * @param srcPath 	移动的源文件路径
	 * @param destPath 	移动的目标文件路径
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean moveFile(String srcPath, String destPath) {
		try {
			FileUtils.moveFile(new File(srcPath), new File(destPath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon移动文件时：" + e.toString());
			return false;
		}
	}

	/**
	 * 移动目录
	 * @author Rocye
	 * @param srcPath 	移动目录的源路径
	 * @param destPath 	移动目录的目的路径
	 * @param isMoveRoot 是否移动根目录 true 为移动根目录 false 为不移动根目录，只移动根目录下的所有文件以及文件夹
	 * @return true OR false
	 * @version 2017.02.28
	 */
	public static boolean moveFolder(String srcPath, String destPath, boolean isMoveRoot) {
		try {
			if(isMoveRoot){
				FileUtils.moveDirectoryToDirectory(new File(srcPath), new File(destPath), true);
			}else{
				FileUtils.moveDirectory(new File(srcPath), new File(destPath));
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ApacheCommon移动文件夹时：" + e.toString());
			return false;
		}
	}

	/**
	 * 搜索文件夹
	 * @param folderPath 文件夹路径
	 * @param folderName 要搜索的文件夹名称
	 * @return 返回文件夹路径
	 */
	public static String searchFolders(String folderPath, String folderName) {
		folderPath = folderPath.replace(File.separator, "/");
		try {
			File tempfile = new File(folderPath);
			String tempPath;
			if(!tempfile.exists()) return "";
			if (tempfile.isDirectory()) {
				File[] fList = tempfile.listFiles();
				for (int i = 0; i < fList.length; i++){
					if (fList[i].isDirectory()){
						if (folderPath.endsWith("/"))
							folderPath = folderPath.substring(0, folderPath.length() - 1);
						tempPath =  folderPath + "/" + fList[i].getName();
						if ((fList[i].getName()).equals(folderName)){
							return tempPath;
						}else{
							tempPath = searchFolders(folderPath + "/" + fList[i].getName(),folderName);
							if(!tempPath.equals(""))return  tempPath;
						}
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	/**
	 * 搜索文件
	 * @param folderPath 文件夹路径
	 * @param fileName 要搜索的文件名称
	 * @return 返回文件路径
	 */
	public static String searchFile(String folderPath, String fileName) {
		folderPath = folderPath.replace(File.separator, "/");
		try {
			File tempfile = new File(folderPath);
			String tempPath;
			if(!tempfile.exists()){
				return "";
			}
			if(tempfile.isFile()){
				if(tempfile.getName().equals(fileName)) return folderPath;
			}
			if (tempfile.isDirectory()) {
				File[] fList = tempfile.listFiles();
				for (int i = 0; i < fList.length; i++){
					if (folderPath.endsWith("/")){
						folderPath = folderPath.substring(0, folderPath.length() - 1);
					}
					tempPath = searchFile(folderPath + "/" + fList[i].getName(),fileName);
					if(!tempPath.equals("")){
						return tempPath;
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}
	
	/**
     * 下载网络文件并保存
     * @author Rocye
     * @param urlStr 网络地址
     * @param filePathAndName 保存后的文件全路径
     * @return 文件名
     */
	public static String downloadWebFile(String urlStr, String filePathAndName){
	    InputStream is = null;
	    try{
	        URL url = new URL(urlStr);
	        URLConnection con = url.openConnection();
	        is = con.getInputStream();
	        
	        String fileName = writeFile(is, filePathAndName);
	        return fileName;
	    }catch (Exception e) {
	        logger.error("下载图片时：" + e.getMessage());
            return null;
        }finally{
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                logger.error(e.toString());
            }
        }
	}

}
