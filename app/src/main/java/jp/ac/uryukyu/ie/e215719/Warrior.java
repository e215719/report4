package jp.ac.uryukyu.ie.e215719;

/**
 * ウォーリアクラス。
 */
public class Warrior extends Hero {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public Warrior (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * 攻撃するメソッド。
     * 自身が死亡しているとき攻撃しない。
     * attackと倍率によって固定のダメージを算出し、wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attackWithWeponSkill(LivingThing opponent) {
        if(!dead) {
        int damage = (int)(attack * 1.5);
        System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
        }
    }
}