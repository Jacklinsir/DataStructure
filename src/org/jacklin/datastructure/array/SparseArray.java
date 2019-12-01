package org.jacklin.datastructure.array;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * 二维数组转稀疏数组 // 稀疏数组转二维数据 // 稀疏数组保存到磁盘 // 在磁盘的稀疏数组读取到代码中//
 * 
 * @author linsir
 */
public class SparseArray {

	private static BufferedInputStream bufferedInputStream;

	public static void main(String[] args) {
		// 创建二维数组
		System.out.println("=========二维数组=========");
		int[][] charArray1 = createNumArray();
		foreachMethod(charArray1);
		// 通过二维数组压缩成稀疏数组
		System.out.println("=========二维数组转稀疏数组=========");
		int[][] sparseArray = sparseArray(charArray1);
		foreachMethod(sparseArray);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sparseArray.length; i++) {
			builder.append(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
			builder.append("\n");
		}

		// 把数据存档到本地SparseArray.data
		IoOutMethod(builder);

		System.out.println("=========稀疏数组转二维数组=========");
		// 初始化二维数组
		int[][] charArray2 = charNumArry2(sparseArray);

		// 遍历二维数组
		foreachMethod(charArray2);

		System.out.println("=========文件存档稀疏数组=========");
		// 将SparseArray.txt文件读取存入稀疏数组中
		String arrayAndFile = sparseArrayAndFile("SparseArray.data");
		String[] split = arrayAndFile.split(",");
		int count = 0;
		for (int i = 0; i < split.length; i++) {
			System.out.print(split[i] + "\t");
			count++;
			if (count == 3) {
				count = 0;
				System.out.println();
			}
		}

	}

	/**
	 * 稀疏数组转二维数组
	 * 
	 * @param sparseArray
	 * @return
	 */
	private static int[][] charNumArry2(int[][] sparseArray) {
		int[][] charArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i < sparseArray.length; i++) {
			// 第一个游标是行数，第二个游标事列数 sparseArray[i][2];==》表示具体值
			charArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		return charArray2;
	}

	/**
	 * 遍历数组
	 * 
	 * @param charArray2
	 */
	private static void foreachMethod(int[][] charArray2) {
		// 遍历二维数组
		for (int[] row : charArray2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

	/**
	 * 使用输出缓存流IoOutMethod读取出本地文件
	 * 
	 * @param dir
	 * @return
	 */
	public static String IoInputMethod(String dir) {
		StringBuilder builder = new StringBuilder();
		try {
			FileInputStream fileInputStream = new FileInputStream(dir);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
				String chunk = new String(buffer, 0, bytesRead);
				builder.append(chunk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

	/**
	 * 解析读取文件字符串内容
	 * 
	 * @param dir
	 * @return
	 */
	private static String sparseArrayAndFile(String dir) {
		String data = IoInputMethod(dir);
		StringBuilder builder = new StringBuilder();
		String[] strings = data.split("\n");
		for (int i = 0; i < strings.length; i++) {
			String[] split = strings[i].split(",");
			for (int j = 0; j < split.length; j++) {
				String[] temp = split[j].split("\t");
				for (int k = 0; k < temp.length; k++) {
					builder.append(temp[k] + ",");
				}
			}
		}
		return builder.toString();
	}

	/**
	 * 使用缓冲流保存稀疏数组Io磁盘
	 * 
	 * @param builder
	 */
	private static void IoOutMethod(StringBuilder builder) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("SparseArray.data");
			// 缓冲流
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
			byte[] data = builder.toString().getBytes();
			bufferedOutputStream.write(data);
			bufferedOutputStream.flush();
			fileOutputStream.close();
			bufferedOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建稀疏数组
	 * 
	 * @param charArray1
	 * @return
	 */
	private static int[][] sparseArray(int[][] charArray1) {
		// 从二维数组获取有效数值的个数
		int sum = 0;
		for (int i = 0; i < charArray1.length; i++) {
			for (int j = 0; j < charArray1.length; j++) {
				if (charArray1[i][j] != 0) {
					sum++;
				}
			}
		}
		// 创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		// 初始化第一列数据
		sparseArray[0][0] = 11; // 二维数组行数
		sparseArray[0][1] = 11;// 二维数组列数
		sparseArray[0][2] = sum;// 有效个数总数
		int count = 0;
		for (int i = 0; i < charArray1.length; i++) {
			for (int j = 0; j < charArray1.length; j++) {
				if (charArray1[i][j] != 0) {
					count++; // 行数++
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = charArray1[i][j];
				}
			}
		}
		return sparseArray;
	}

	/**
	 * 创建二维数组
	 * 
	 * @return
	 */
	private static int[][] createNumArray() {
		// 创建二维数组 - 11*11
		int[][] charArray1 = new int[11][11];
		charArray1[1][2] = 1;
		charArray1[2][3] = 2;
		charArray1[4][5] = 5;
		charArray1[5][6] = -6;
		return charArray1;
	}
}
