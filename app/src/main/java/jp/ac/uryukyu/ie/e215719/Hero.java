package jp.ac.uryukyu.ie.e215719;

/**
 * ヒーロークラス。
 */
public class Hero extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引く。
     * @param damage 受けたダメージ
     */
    @Override 
    public void wounded(int damage){
        this.hitPoint -= damage;
        if(isDead()) {
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}