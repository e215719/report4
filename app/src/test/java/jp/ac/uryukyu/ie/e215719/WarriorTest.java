package jp.ac.uryukyu.ie.e215719;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    /**
     * attackWithWeponSkillを実行し、attackの150%ダメージになっていることを確認。
     * 検証手順
     *  (1) ウォーリアと敵を準備。ウォーリアの攻撃力は100とする。
     *  (2) 敵にウォーリアが150ダメージを与えることを期待。
     *  (3) ウォーリアが与えたダメージは150になるはず。
     * 　　つまりウォーリアが与えたダメージと150が等しいことを期待。これを3回検証する。
     */
    @Test
    void attackTest() {
        int defaultWarriorAttack = 100;
        Warrior demoWarrior = new Warrior("デモ勇者", 500, defaultWarriorAttack);
        Enemy slime = new Enemy("スライムもどき", 500, 100);
        for (int i=1; i<3; i++) {
        demoWarrior.attackWithWeponSkill(slime);
        assertEquals(defaultWarriorAttack*1.5, 150);
        }
    }
}