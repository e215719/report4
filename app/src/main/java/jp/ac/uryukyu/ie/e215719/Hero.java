package jp.ac.uryukyu.ie.e215719;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created 2021/11/10.
 */
public class Hero {
    private String name;
    /**
    * nameのsetterメソッド。
    * name変更時に条件をで設定の許可をする。
    * @param name 設定対象
    */
    public void setName(String name) {
        if (name.length() == 0) {
            System.out.println("入力がないので「勇者」となります");
            this.name = "勇者";
        } else {
            this.name = name;
        }
    }
    /**
    * nameのgetterメソッド。
    * nameを取得する。
    * @param name 取得対象
    */
    public String getName() {
        return this.name;
    }
    private int hitPoint;
    /**
    * hitPointのgetterメソッド。
    * HPを取得する。
    * @param hitPoint 取得対象
    */
    public int getHitPoint() {
        return this.hitPoint;
    }
    private int attack;
    /**
    * attackのsetterメソッド。
    * 攻撃力を設定する。
    * @param attack 設定対象
    */
    public void setAttack(int attack) {
        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }
    private boolean dead;
    /**
    * deadのgetterメソッド。
    * 生死状態を取得する。
    * @param dead 取得対象
    */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}