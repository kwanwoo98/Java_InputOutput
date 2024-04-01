package com.bitc.java404;

import java.io.*;
import java.util.Scanner;

public class JavaStreamTest {
    // 문제 1) 사용자 입력을 통해서 파일 이름을 입력받고 해당 파일의 내용을 화면에 출력하는 프로그램을 작성하세요
    // 파일명 quiz1.txt
    // 내용 : 영어로 아무거나 입력.
    public void quiz1(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("파일 이름을 입력하세요: ");
        String fileName = scanner.nextLine();

        try {
            // 파일 열기
            InputStream is = new FileInputStream(fileName);

            // 파일 내용을 저장할 문자열
            StringBuilder contents = new StringBuilder();

            // 파일 내용 읽어와 문자열에 저장
            byte[] buffer = new byte[1024]; // 버퍼 크기 지정
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                contents.append(new String(buffer, 0, bytesRead));
            }

            // 파일 내용 출력
            System.out.println(contents);

            // 스트림 닫기
            is.close();
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    // 문제 2) 기조에 존재하는 파일을 열고 사용자 입력을 통해서 입력받은 내용을 기존 파일의 뒤에 추가하는 프로그램을 작성하시오
    // 파일명 : quiz2.txt
    // 원본 내용 : netwrok programing
    public static void quiz2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 파일 경로 지정
        String filePath = "C:/java404/quiz2.txt";

        try {
            // 파일 열기 (추가 모드)
            OutputStream os = new FileOutputStream(filePath, true);

            System.out.println("파일에 추가할 내용을 입력하세요. 입력을 마치려면 빈 줄에서 엔터를 누르세요.");

            // 사용자 입력 받아 파일에 추가
            while (true) {
                String input = scanner.nextLine();
                // 사용자가 엔터만 입력하면 입력 종료
                if (input.isEmpty()) {
                    break;
                }
                // 입력된 내용을 파일에 쓰기
                os.write(input.getBytes());
                os.write("\n".getBytes()); // 각 입력 라인 끝에 개행 추가
            }

            // 스트림 닫기
            os.close();

            System.out.println("파일에 내용을 추가했습니다.");
        } catch (IOException e) {
            System.out.println("파일에 쓰는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    // 문제 3) 사용자 입력을 통해서 파일의 원본 파일의 이름과 사본 파일의 이름을 입력받고, 원본 파일의 내용을 사본 파일에 저장하는 프로그램을 작성하세요
    // 원본 파일명 : quiz3.txt
    // 원본 내용 : network programing quiz3
    // 사본 파일명 : quiz3_copy.txt
    public static void quiz3(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 원본 파일 이름 입력 받기
            System.out.print("원본 파일의 경로를 입력하세요: ");
            String originalFilePath = scanner.nextLine();

            // 사본 파일 이름 입력 받기
            System.out.print("사본 파일의 경로를 입력하세요: ");
            String copyFilePath = scanner.nextLine();

            // 원본 파일 열기
            InputStream originalFileInputStream = new FileInputStream(originalFilePath);
            // 사본 파일 열기 (덮어쓰기 모드)
            OutputStream copyFileOutputStream = new FileOutputStream(copyFilePath);

            // 원본 파일 내용을 사본 파일로 복사
            byte[] buffer = new byte[1024]; // 버퍼 크기 지정
            int bytesRead;
            while ((bytesRead = originalFileInputStream.read(buffer)) != -1) {
                copyFileOutputStream.write(buffer, 0, bytesRead);
            }

            // 스트림 닫기
            originalFileInputStream.close();
            copyFileOutputStream.close();

            System.out.println("파일을 복사했습니다.");
        } catch (IOException e) {
            System.out.println("파일을 복사하는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}








