package jp.ac.uryukyu.ie.e215719;

/**
 * 生き物クラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    
    /**
     * 死亡判定を行うメソッド。
     */
    public boolean isDead(){
        if( hitPoint <= 0 ) {
            this.dead = true;
        }
        return this.dead;
    }
    /**
    * nameのgetterメソッド。
    * nameを取得する。
    * @param name 取得対象
    */
    public String getName() {
        return this.name;
    }
    /**
     * 攻撃するメソッド。
     * 自身が死亡しているとき攻撃しない。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(!dead) {
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引く。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if(isDead()) {
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}