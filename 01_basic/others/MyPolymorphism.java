// src:  https://t.ly/mkKm

import java.util.Scanner;

interface Overwatch {
    void name();
    void lClick();
    void rClick();
    void shiftButton();
    void eButton();
    void qButton();
}

class Mei implements Overwatch {
    public void name() {
        System.out.println("이름: 메이");
    }

    public void lClick() {
        System.out.println("좌클릭: 냉각총");
    }

    public void rClick() {
        System.out.println("우클릭: 고드름 투사체");
    }

    public void shiftButton() {
        System.out.println("shift: 급속 빙결");
    }

    public void eButton() {
        System.out.println("e: 빙벽");
    }

    public void qButton() {
        System.out.println("q: 황야의 무법자(궁극기)");
    }
}


class Reaper implements Overwatch {
    public void name() {
        System.out.println("이름: 리퍼");
    }

    public void lClick() {
        System.out.println("좌클릭: 헬파이서 샷건");
    }

    public void rClick() {
        System.out.println("우클릭: 없음");
    }

    public void shiftButton() {
        System.out.println("shift: 망령화");
    }

    public void eButton() {
        System.out.println("e: 그림자 밟기");
    }

    public void qButton() {
        System.out.println("q: 죽음의 꽃(궁극기)");
    }
}

class Mccree implements Overwatch {
    public void name() {
        System.out.println("이름: 맥크리");
    }

    public void lClick() {
        System.out.println("좌클릭: 피스키퍼");
    }

    public void rClick() {
        System.out.println("우클릭: 모든 총알 발사");
    }

    public void shiftButton() {
        System.out.println("shift: 구르기");
    }

    public void eButton() {
        System.out.println("e: 섬광탄");
    }

    public void qButton() {
        System.out.println("q: 황야의 무법자(궁극기)");
    }
}


public class MyPolymorphism {
    public static void main(String[] args) {
        Overwatch ow;
        System.out.println("플레이할 캐릭터 번호선택(1. 메이, 2. 리퍼, 3. 맥크리)");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            ow = new Mei();
        } else if (n == 2) {
            ow = new Reaper();
        } else {
            ow = new Mccree();
        }

        ow.name();
        ow.lClick();
        ow.rClick();
        ow.shiftButton();
        ow.eButton();
        ow.qButton();
    }
}
