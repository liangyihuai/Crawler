import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liangyh on 2/11/2017.
 */
public class Test {
    public static void main(String[] args) {
        getLinks(htmlPage);
    }

    private static String htmlPage = "</div>\n" +
            "            \n" +
            "\t\t    <div class=\"card mt20\">\n" +
            "\t\t        <div class=\"header line\">\n" +
            "\t\t            <h2>大主宰 最新章节列表</h2>\n" +
            "\t\t        </div>\n" +
            "\t\t        <div class=\"body \">\n" +
            "\t\t            <ul class=\"dirlist clearfix\">\n" +
            "\t\t                \t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1443.html\" title=\"大主宰 第一千四百四十九章 百灵王 2017-02-14 13:53:35\" target=\"_blank\">第一千四百四十九章 百灵王</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1442.html\" title=\"大主宰 第一千四百四十八章 百灵大陆 2017-02-13 15:46:14\" target=\"_blank\">第一千四百四十八章 百灵大陆</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1441.html\" title=\"大主宰 第一千四百四十七章 晋级的圣浮屠塔 2017-02-12 14:59:27\" target=\"_blank\">第一千四百四十七章 晋级的圣浮屠塔</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1439.html\" title=\"大主宰 第一千四百二十六章 见面礼 2017-02-11 00:16:53\" target=\"_blank\">第一千四百二十六章 见面礼</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1438.html\" title=\"大主宰 第一千四百二十五章 变天的浮屠古族 2017-02-09 22:14:08\" target=\"_blank\">第一千四百二十五章 变天的浮屠古族</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1437.html\" title=\"大主宰 第一千四百二十四章 新任大长老 2017-02-08 12:23:54\" target=\"_blank\">第一千四百二十四章 新任大长老</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1436.html\" title=\"大主宰 第一千四百二十三章 圣品之战 2017-02-06 22:26:44\" target=\"_blank\">第一千四百二十三章 圣品之战</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1435.html\" title=\"大主宰 第一千四百二十二章 清衍静现身 2017-02-06 14:35:19\" target=\"_blank\">第一千四百二十二章 清衍静现身</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1434.html\" title=\"大主宰 第一千四百二十一章 浮屠玄出手 2017-02-05 13:16:35\" target=\"_blank\">第一千四百二十一章 浮屠玄出手</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1433.html\" title=\"大主宰 第一千四百二十章 一人敌族 2017-02-03 14:15:53\" target=\"_blank\">第一千四百二十章 一人敌族</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1432.html\" title=\"大主宰 第一千四百一十九章 一人战浮屠 2017-02-01 22:52:40\" target=\"_blank\">第一千四百一十九章 一人战浮屠</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1431.html\" title=\"大主宰 第一千四百一十八章 再起斗执 2017-01-31 13:37:22\" target=\"_blank\">第一千四百一十八章 再起斗执</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1430.html\" title=\"大主宰 第一千四百一十七章 神光震古族 2017-01-30 11:56:51\" target=\"_blank\">第一千四百一十七章 神光震古族</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1429.html\" title=\"大主宰 第一千四百一十六章 神脉对决 2017-01-28 20:41:40\" target=\"_blank\">第一千四百一十六章 神脉对决</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1428.html\" title=\"大主宰 第一千四百一十五章 激战仙品 2017-01-27 12:24:46\" target=\"_blank\">第一千四百一十五章 激战仙品</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1427.html\" title=\"大主宰 第一千四百一十四章 仙品出手 2017-01-25 21:54:42\" target=\"_blank\">第一千四百一十四章 仙品出手</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1426.html\" title=\"大主宰 第一千四百一十三章 暴打 2017-01-23 14:51:42\" target=\"_blank\">第一千四百一十三章 暴打</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1425.html\" title=\"大主宰 第一千四百一十二章 再斗黑光 2017-01-22 21:34:01\" target=\"_blank\">第一千四百一十二章 再斗黑光</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1424.html\" title=\"大主宰 第一千四百一十一章 一招一个 2017-01-22 17:45:31\" target=\"_blank\">第一千四百一十一章 一招一个</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1423.html\" title=\"大主宰 第一千四百一十章 一人战玄脉 2017-01-22 13:08:46\" target=\"_blank\">第一千四百一十章 一人战玄脉</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1422.html\" title=\"大主宰 第一千四百零九章 新清脉脉首 2017-01-21 22:26:39\" target=\"_blank\">第一千四百零九章 新清脉脉首</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1421.html\" title=\"大主宰 第一千四百零八章 家母,清衍静 2017-01-19 19:14:32\" target=\"_blank\">第一千四百零八章 家母,清衍静</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1420.html\" title=\"大主宰 第一千四百零七章 清脉之败 2017-01-18 20:36:12\" target=\"_blank\">第一千四百零七章 清脉之败</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1419.html\" title=\"大主宰 第一千四百零六章 三脉之首 2017-01-17 13:16:03\" target=\"_blank\">第一千四百零六章 三脉之首</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1418.html\" title=\"大主宰 第一千四百零五章 浮屠玄 2017-01-15 14:22:56\" target=\"_blank\">第一千四百零五章 浮屠玄</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1417.html\" title=\"大主宰 第一千四百零四章 席位之争 2017-01-13 14:08:59\" target=\"_blank\">第一千四百零四章 席位之争</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1416.html\" title=\"大主宰 第一千四百零三章 清脉之势 2017-01-11 20:26:41\" target=\"_blank\">第一千四百零三章 清脉之势</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1415.html\" title=\"大主宰 第一千四百零二章 浮屠界 2017-01-10 14:21:16\" target=\"_blank\">第一千四百零二章 浮屠界</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1414.html\" title=\"大主宰 第一千四百零一章 摩诃幽 2017-01-08 16:22:43\" target=\"_blank\">第一千四百零一章 摩诃幽</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1413.html\" title=\"大主宰 第一千四百章 浮屠城 2017-01-08 00:22:54\" target=\"_blank\">第一千四百章 浮屠城</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1412.html\" title=\"大主宰 第一千三百九十九章 神脉震玄天 2017-01-06 17:15:13\" target=\"_blank\">第一千三百九十九章 神脉震玄天</a></li>\n" +
            "\t\t                \t\t                <li style=\"width:50%;\"><a href=\"/1/1411.html\" title=\"大主宰 第一千三百九十八章 灵脉殿 2017-01-05 18:52:09\" target=\"_blank\">第一千三百九十八章 灵脉殿</a></li>\n" +
            "\t\t                \t\t            </ul>\n" +
            "\t\t        </div>\n" +
            "                <div class=\"footer tar\">\n" +
            "                    <a href=\"/1/\" title=\"大主宰最新章节列表\" target=\"_blank\">《大主宰》章节列表...</a>\n" +
            "                </div>\n" +
            "\t\t    </div>\n" +
            "            \n" +
            "            \n" +
            "            \n" +
            "                        <div class=\"card mt20\">\n" +
            "                <div class=\"header line\">\n" +
            "                    <h3>小说推荐</h3>\n" +
            "                </div>\n" +
            "                <div class=\"body\">\n" +
            "                    <div class=\"novellist\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"item\">\n" +
            "                            <div class=\"item-left\">\n" +
            "                                <a href=\"/210/\" title=\"修罗武神\"><img src=\"http://img.daizhuzai.com/public/cover/62/f8/e1/62f8e15aabfe616efc350bf626d06ef9.jpg\" alt=\"修罗武神\"></a>\n" +
            "                            </div>\n" +
            "                            <div class=\"item-right\">\n" +
            "                                <dl>\n" +
            "                                    <dt><a href=\"/210/\" title=\"修罗武神\">修罗武神</a></dt>\n" +
            "                                    <dd>作者：<a href=\"/author/%E5%96%84%E8%89%AF%E7%9A%84%E8%9C%9C%E8%9C%82/\" title=\"善良的蜜蜂 作品大全\">善良的蜜蜂</a></dd>\n" +
            "                                    <dd class=\"intro\">论潜力，不算天才，可玄功武技，皆可无师自通。\n" +
            "论魅力，千金小姐算什么，妖女圣女，都爱我欲罢不能。\n" +
            "论实力，任凭你有万千至宝，但定不敌我界灵大军。\n" +
            "我是谁？天下众生视我为修罗，却不知，我以修罗成武神。\n" +
            "等级：灵武，元武，玄武，天武，武君，武王，武帝，武祖....\n" +
            "〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n" +
            "《修罗武神》书友①群：235793395（敲门砖，书中主角名字）\n" +
            "</dd>\n" +
            "                                </dl>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"item\">\n" +
            "                            <div class=\"item-left\">\n" +
            "                                <a href=\"/10/\" title=\"圣墟\"><img src=\"http://img.daizhuzai.com/public/cover/eb/8d/71/eb8d71f96115a51bbdefdf00c353a0e7.jpg\" alt=\"圣墟\"></a>\n" +
            "                            </div>\n" +
            "                            <div class=\"item-right\">\n" +
            "                                <dl>\n" +
            "                                    <dt><a href=\"/10/\" title=\"圣墟\">圣墟</a></dt>\n" +
            "                                    <dd>作者：<a href=\"/author/%E8%BE%B0%E4%B8%9C/\" title=\"辰东 作品大全\">辰东</a></dd>\n" +
            "                                    <dd class=\"intro\">在破败中崛起，在寂灭中复苏。 \n" +
            "    沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角……\n" +
            "\n" +
            "东哥新书《圣墟》开书在即，继完美世界之后辰东11月1日再开神书，圣墟少年主角楚风即将传遍网文界。 …作者话：新书圣墟开始了，请所有兄弟姐妹继续支持辰东，感谢你们。</dd>\n" +
            "                                </dl>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"item\">\n" +
            "                            <div class=\"item-left\">\n" +
            "                                <a href=\"/199/\" title=\"雪鹰领主\"><img src=\"http://img.daizhuzai.com/public/cover/06/fc/0a/06fc0abc6463ed3bc48a9218f2ba24ea.jpg\" alt=\"雪鹰领主\"></a>\n" +
            "                            </div>\n" +
            "                            <div class=\"item-right\">\n" +
            "                                <dl>\n" +
            "                                    <dt><a href=\"/199/\" title=\"雪鹰领主\">雪鹰领主</a></dt>\n" +
            "                                    <dd>作者：<a href=\"/author/%E6%88%91%E5%90%83%E8%A5%BF%E7%BA%A2%E6%9F%BF/\" title=\"我吃西红柿 作品大全\">我吃西红柿</a></dd>\n" +
            "                                    <dd class=\"intro\">深海魔兽的呼吸形成永不停息的风暴……\n" +
            "熔岩巨人的脚步毁灭一座座城池……\n" +
            "深渊恶魔想要侵入这座世界……\n" +
            "而神灵降临，行走人间传播他的光辉……\n" +
            "然而整个世界由夏族帝国‘龙山帝国’统治，这是人类的帝国，知识渊博的法师们埋首于法师塔中百年千年，骑士们巡守天空大地海洋……\n" +
            "在帝国的安阳行省，有一个很小很不起眼的贵族领地，叫——雪鹰领！\n" +
            "故事，就从这里开始！\n" +
            "******\n" +
            "继《莽荒纪》《吞噬星空》《九鼎记》《盘龙》《星辰变》《寸芒》《星峰传说》后，番茄的第八本小说！\n" +
            "</dd>\n" +
            "                                </dl>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"item\">\n" +
            "                            <div class=\"item-left\">\n" +
            "                                <a href=\"/47/\" title=\"斗破苍穹\"><img src=\"http://img.daizhuzai.com/public/cover/2c/d0/e4/2cd0e430ebf8ff55e62ccdce8d5a7d0a.jpg\" alt=\"斗破苍穹\"></a>\n" +
            "                            </div>\n" +
            "                            <div class=\"item-right\">\n" +
            "                                <dl>\n" +
            "                                    <dt><a href=\"/47/\" title=\"斗破苍穹\">斗破苍穹</a></dt>\n" +
            "                                    <dd>作者：<a href=\"/author/%E5%A4%A9%E8%9A%95%E5%9C%9F%E8%B1%86/\" title=\"天蚕土豆 作品大全\">天蚕土豆</a></dd>\n" +
            "                                    <dd class=\"intro\">这里是属于斗气的世界，没有花俏艳丽的魔法，有的，仅仅是繁衍到巅峰的斗气！\n" +
            "想要知道异界的斗气在展到巅峰之后是何种境地吗？请观斗破苍穹^_^\n" +
            "等级制度：斗者，斗师，大斗师，斗灵，斗王，斗皇，斗宗，斗尊，斗圣，斗帝。\n" +
            "</dd>\n" +
            "                                </dl>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"clear\"></div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            \n" +
            "\t\t\t            \n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t            <div class=\"card mt20\">\n" +
            "                <div class=\"header line\">\n" +
            "                    <h3>最新更新小说</h3>\n" +
            "                </div>\n" +
            "                <div class=\"body\">\n" +
            "                    <ul class=\"updatelist\">\n" +
            "                                                                        <li>\n" +
            "                            <span class=\"n\"><a href=\"/1311/\" title=\"侯府商女\"><strong>侯府商女</strong></a></span>\n" +
            "                            <span class=\"c\"><a href=\"/1311/list.html\" title=\"侯府商女 第1196章：我等不服做出承诺！\" target=\"_blank\">侯府商女 第1196章：我等不服做出承诺！</a></span>\n" +
            "                            <span class=\"a\"><a href=\"/author/%E4%B8%8A%E5%AE%98%E6%97%AD%E4%BA%91/\" title=\"上官旭云\">上官旭云</a></span>\n" +
            "                            <span class=\"t\">21:30</span>\n" +
            "                        </li>\n" +
            "                                                <li>\n" +
            "                            <span class=\"n\"><a href=\"/9564/\" title=\"机甲修女俏神父\"><strong>机甲修女俏神父</strong></a></span>\n" +
            "                            <span class=\"c\"><a href=\"/9564/list.html\" title=\"机甲修女俏神父 第五十一章 戏言之人与神的孩子？（下）\" target=\"_blank\">机甲修女俏神父 第五十一章 戏言之人与神的孩子？（下）</a></span>\n" +
            "                            <span class=\"a\"><a href=\"/author/%E8%A2%AB%E7%8B%99%E5%87%BB%E7%9A%84%E9%AD%94%E7%8E%8B/\" title=\"被狙击的魔王\">被狙击的魔王</a></span>\n" +
            "                            <span class=\"t\">21:29</span>\n" +
            "                        </li>\n" +
            "                                                <li>\n" +
            "                            <span class=\"n\"><a href=\"/8875/\" title=\"女校小保安\"><strong>女校小保安</strong></a></span>\n" +
            "                            <span class=\"c\"><a href=\"/8875/list.html\" title=\"女校小保安 第1997章 成为武修者\" target=\"_blank\">女校小保安 第1997章 成为武修者</a></span>\n" +
            "                            <span class=\"a\"><a href=\"/author/%E7%B4%A0%E6%89%8B%E6%B7%BB%E9%A6%99/\" title=\"素手添香\">素手添香</a></span>\n" +
            "                            <span class=\"t\">21:29</span>\n" +
            "                        </li>";

    public static Set<String> getLinks(String htmlPage){
        Set<String> result = new HashSet<String>();

        Pattern pattern = Pattern.compile("(<a\\shref=\")(/\\d/\\d{4,}.html)(\"\\stitle=\"大主宰.*</a>)");
        Matcher matcher = pattern.matcher(htmlPage);

        while(matcher.find()){
            String url = matcher.group(2);
            System.out.println(url);
            result.add(url);
        }
        return result;
    }
}
