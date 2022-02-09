-- noinspection SqlNoDataSourceInspectionForFile

NULL	值是一个 NULL 值。
INTEGER	值是一个带符号的整数，根据值的大小存储在 1、2、3、4、6 或 8 字节中。
REAL	值是一个浮点值，存储为 8 字节的 IEEE 浮点数字。
TEXT	值是一个文本字符串，使用数据库编码（UTF-8、UTF-16BE 或 UTF-16LE）存储。
BLOB	值是一个 blob 数据，完全根据它的输入存储。

drop table if exists User;
create table User
(
    Id       TEXT not null,
    Username TEXT,
    Password TEXT,
    Nickname TEXT,
    Realname TEXT,
    Avatar   TEXT,
    CONSTRAINT PK_User primary key (Id)
);

drop table if exists Groups;
create table Groups
(
    Id          TEXT not null,
    Title       TEXT,
    Description TEXT,
    Leader      TEXT,
    CreateBy    TEXT,
    CreateAt    TEXT,
    Avatar      TEXT,
    CONSTRAINT Pk_Groups primary key (Id)
);

drop table if exists GroupsUser;
create table GroupsUser
(
    GroupId TEXT not null,
    UserId  TEXT not null,
    CONSTRAINT Pk_GroupsUser primary key (GroupId, UserId)
);

drop table if exists Article;
create table Article
(
    Id           TEXT not null,
    Title        TEXT,
    Content      TEXT,
    Description  TEXT,
    IsOriginal   INTEGER,
    Type         INTEGER,
    Url          TEXT,
    CreateBy     TEXT,
    CreateAt     TEXT,
    ModifyAt     TEXT,
    CommentCount INTEGER,
    ViewCount    INTEGER,
    LikeCount    INTEGER,
    Tag          TEXT,
    GroupId      TEXT,
    CONSTRAINT PK_Question PRIMARY KEY (Id)
);

delete from Article where  Id is not null;
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('81','够了，别动不动就骂她堕落','description',1,'https://mp.weixin.qq.com/s/RPyqZCeTi7mRpIgJgrJ1Ug',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('82','有人在为西安地铁女孩发声，有人在求她的高清无码视频','description',1,'https://mp.weixin.qq.com/s/oDl98MGFEXn6Kfo1e11KTQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('83','“主动吃避孕药就是不自爱？”别再随便骂这颗小药丸了！| 女性安全指南183','description',1,'https://mp.weixin.qq.com/s/FEBesp6V_rUAjyaUGNsgwQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('84','麻醉阴道，献祭初夜，女孩的「第一次」需要这么拼吗？ | 女性安全指南181','description',1,'https://mp.weixin.qq.com/s/FW_mDUKyxaPCnPO-WdGLXA',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('85','你以为的时尚街拍，其实都是付费小片','description',1,'https://mp.weixin.qq.com/s/8EWqYSIn-RGuUTmxKUwufA',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('86','“200斤的肥肉面前，再厉害的简历也成了废纸”｜5XL女孩的自白','description',1,'https://mp.weixin.qq.com/s/rM8vvv_EZ9BKrG14BgXRzw',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('87','上不去热搜的「她」，可以被你拯救','description',1,'https://mp.weixin.qq.com/s/7viGzKgyg1xD3utx4hOzug',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('88','她驱船乘风破浪，只为了帮女人们堕胎','description',1,'https://mp.weixin.qq.com/s/320lqZWB24sFaihPgIRXJQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('89','她驱船乘风破浪，只为了帮女人们堕胎','description',1,'https://mp.weixin.qq.com/s/320lqZWB24sFaihPgIRXJQ',0,0,0);

insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('91','这些针对女性的暴力，还在被轻视','description',1,'https://mp.weixin.qq.com/s/oDl98MGFEXn6Kfo1e11KTQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('92','月经提前和月经推迟，哪个对身体更不好？','description',1,'https://mp.weixin.qq.com/s/G7vALXUS96I-o-41ibsP2A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('93','子宫生病的4个信号，很多女生都没当回事','description',1,'https://mp.weixin.qq.com/s/mNAnXYAu7aqaf4Hviu_mKg',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('94','月经来两三天就走是卵巢早衰吗？医生告诉你答案','description',1,'https://mp.weixin.qq.com/s/oJh96NWavsBbUQaJZd5L4A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('95','女性痛经全过程曝光！出现这4个现象，及时看医生','description',1,'https://mp.weixin.qq.com/s/g4VBvxD2EfjGxMHCpPZtow',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('96','如何跟孩子谈“性”，这2个高中生做了最好的示范','description',1,'https://mp.weixin.qq.com/s/2cJFHoCt8b3kRrgfGgTJ2A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('97','90%人都没听说过HPV，每年却有三万女性因此丧命 | 女孩别怕024','description',1,'https://mp.weixin.qq.com/s/-yYtTFqCpF1vfemAy_h1VQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('98','“总感觉我们的关系如履薄冰”面对恋爱中的冷暴力，我该怎么办？ | 女孩别怕049','description',1,'https://mp.weixin.qq.com/s/cp6xK2-yfu1GlCQFV3aS_w',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('99','我跟女警聊了聊，单身女孩在外租房如何判断附近安不安全 | 女孩别怕002','description',1,'https://mp.weixin.qq.com/s/v8pd_B7hJ03NRJEG4xYs0g',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('100','「她一心救人，却被骂姿势不雅。」网络暴力究竟有多可怕｜女孩别怕081','description',1,'https://mp.weixin.qq.com/s/TXxTclMcQh_E6ZTgU5fXYw',0,0,0);

update Article set Description='忘掉她，忘掉她就可以不必再忍受，忘掉她就可以不必再痛苦。忘掉她，忘掉你没有的东西，忘掉别人有的东西，忘掉你失去和以后不能得到的东西，忘掉仇恨，忘掉屈辱，忘掉爱情，像犀牛忘掉草原，像水鸟忘掉湖泊，像地狱里的人忘掉天堂，像截肢的人忘掉自己曾快步如飞，像落叶忘掉风，像图拉忘掉母犀牛。忘掉是一般人能做的惟一的事。但是我决定——不忘掉她。' where Id is not null;


drop table if exists Question;
create table Question
(
  Id           TEXT not null,
  Title        TEXT,
  Description  TEXT,
  CreateBy     TEXT,
  CreateAt     TEXT,
  ModifyAt     TEXT,
  CommentCount INTEGER,
  ViewCount    INTEGER,
  LikeCount    INTEGER,
  Tag          TEXT,
  CONSTRAINT PK_Question PRIMARY KEY (Id)
);

delete from Question where Id is not null;
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('01','结婚前的建议吧，不存在忠告','尽量三十岁之前就把自己嫁了吧，不是说三十之后嫁不出去，而是选择性比较小。如果你还没到三十，你觉得自己男朋友穷，可以再慢慢观察他是否有潜力，是否能够给你婚后带来安全感。如果你过了三十，就别考虑那么多了，就是你男朋友穷，才会等你到三十岁，不然为啥不找个二十出头年轻漂亮的呢。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('02','趁年轻，不妨大胆一些','我说，真羡慕你，潇洒啊。说到这里心里有些不是滋味，自己从毕业到现在，没有任性过，都是积极上班，为了那几两碎银不敢停止脚步。对象跟我一样，刚毕业一年就跟我订婚，第二年就结婚，现在生娃了，还没有来得及好好享受生活。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('03','大多数人，都并没有和喜欢的人结婚','或许当我们年纪很小的时候，我们会理所当然的觉得，遇见一个和自己相互喜欢的人，那是一件很简单的事情，在自己出生的那一刻，已经有那么一个人，专门为我们准备好了。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('04','体罚打脚心','上次我们班主任因为一个女生考试数学打了五十二分，（确实很难）体罚她，拿个戒尺让她把鞋脱了脱袜子拿起教鞭当着全班的面啪啪打脚心，那个女同学皮肤很敏感，本来怕疼，长得挺漂亮，还是班里有时的学霸，后来她的脚就被打得红了',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('05','异地要分手吗？','跟我对象相亲认识的，然后现在年龄也不小了，所以双方家里还都挺急的。但是现在的问题是我们是异地，我个人完全不接受异地婚姻。（当时接触的时候是以为他短期会回来，没想到会长期在深圳。）我自己本身性格比较内向，又是母胎solo，但是跟他觉得还挺聊得来的，中间见面五六次，都觉得印象不错,但没有特别喜欢。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('06','找姐姐，希望可以监督学习','监督学习就行，有家规也行。本人比较懒，很多事情都不愿意去做，希望有个姐姐能来管管。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('07','需要找暗恋对象说话吗？','如题，暗恋太多年了。2018年10月份我们失去了联系，是我单方面删他的。今年又加了回来？我要回老家，再想要不要问他我回去呢见一面。之前他说找到工作了，我回老家他要请我吃饭。现在纠结要不要以此为借口找他？',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('08','离婚没有小孩的女人 还有机会吗 ','结婚两年多 离婚半年 没有小孩 对于未来很迷茫 不敢告诉身边的人离婚了 害怕被人带着有色眼镜看待 朋友都安慰现在离婚的人很多 不用担心这些 可是心里还是很介意 觉得离过婚会被人用异样的眼光看待 以后也遇不到好的人 会被嫌弃 这样的想法是不是太狭隘了',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('09','喜欢上一个男生','现高中 他是我一个初中同学的同班同学兼好朋友 前几天通过那个同学要到了他的联系方式 但是不知道聊什么 怎么开启聊天啊',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('10','分分合合，聊一聊那些年见过的痴情男女 ','我有一个朋友，是个长腿细腰葫芦身材的北方女孩，今天给我打电·话，说要跟认识一年的男朋友分手，原因是昨天晚上去吃饭，男的只点了他喜欢吃的菜，两个人中途吵起来，男的居然自己开车走了，玩到半夜三更，喝得醉醺醺的回家。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('11','我一个女孩子，好像喜欢上了别的女孩 ','我刚跟前男友分手3周，其实我自己也早就想分手了。然后我就开始玩社交软件，一个叫心动30秒的。最近我就发现自己不太对劲了因为我在上面认识了一个姐姐，她很知性，很正能量，而且我跟她吐槽我前男友的时候，她都很愿意听，每天我俩聊天都能聊很久，互道早安晚安。但是她最近两天都没上线，她之前给我讲过，她要去相亲，她不会是已经相中了吧！我潜意识里觉得自己的东西被别人霸占了，很生气也很难受。我是不是喜欢上她了？？？',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('12','想知道如何才能判断对方到底是不是认真的想和自己谈恋爱？','我知道钱不是衡量一段感情的标识，我也还是学生也没想对方为自己天天花钱买这个买那个。可是我们在一起这么久里，我每次看到什么适合他的、好看的东西就想给对方买，也刚谈恋爱时也送了情侣手链，第一次七夕节也给对方准备了情侣卫衣，虽然不是说要多贵多贵也好歹是心意，期间过生日也送了自己做的手工礼物和其他的礼物，自己也很用心了，后面跨年我们两见面，他抽烟我给他准备了个ZIPOO打火机，因为那个很好看别人一看就知道是女朋友送的，我觉得很有意义。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('13','不舒服 就直接说 爱不爱能感觉的到 拖着不是办法','我觉得自己总是想太多，这样的我并不适合谈异地恋，太难受了。有件事我自己就非常想不通，他和我谈恋爱他说他室友和家里人都知道，他在学校时也会在宿舍和我聊天，回家后他弟弟和他住一个房间，我和他打电话他也会打，但是每次他朋友在他家时，他都会出来打说朋友在家里，他朋友好像经常住他家，还有下午给他打电话好几次他都没接，他都说和朋友出去玩了手机静音了没看到，要不就直接拒绝了说和朋友在外面，等下再打给我。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('14','不回消息 但是隔天又会主动找我','遇到过，后来内耗受不了分手了，总结就是不太在意你，没有把你放心上，不然一个陌生人都知道应该怎么做，觉得反正你也不会生气，不过要看你是不是晚上发消息，如果晚上发对方第二天能一一回复你的内容，我觉得还可以接受。不然这个年头谁会一天不看手机不回复你。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('15','怎么和异性迅速拉近关系 ','我对他有点好感，他对我也有印象，于是我寒假加了他主动问他问题和他聊天，他比较内向被动一个人，聊了两天之后就没聊了，但是每次聊天都还挺愉快的。只是后一次他回的比较慢，两次聊天都是我主动，我也不知道他有没有女朋友，我到底还要不要主动，虽然以后开学还有见面的机会，但比较只是同一个院的，大学，不常见到。就是说到底还要不要主动',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('16','提问‖搞不懂这种情感 ','就是有一个人很懂你  一起说这说那  好像是有一点不一样的感觉了  突然 那天 说着说着 他就不说了  然后隔了两天 他又回来了 聊着聊着天  我问为什么说着说着没了  一直在问他  他说 我不能说 一直在我的逼问下  他说 我感觉我挺懂你的  我也真的很喜欢你   为什么那天我会消失  因为 我已婚  我当时就哭了 就把他的微信删了  然后又在那个框框里发了好长一段话  他说 我不是为了追求刺激 我也不知道我是为了什么  我也很愧疚 让你伤心了 但是希望你相信美好  美好还是存在的  我就是个渣渣 我希望你开心   我就感觉好难受  虽然不是什么喜欢不喜欢  但是就是 感觉受到了情感欺骗  还会时不时想到  一想到就很难受  想哭  虽然知道他都结婚了 还在外面和我说这说那就是个人渣  但是还总是想这件事  一想到又生气  又难过  想到为什么是我 本来我就是一个重感情的人  各种情感 我都很重视  这样对我  我好难接受  好伤心 我是不是有病 明明道理我都懂的  能不能点醒我   求求了 😞😞😭😭',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('17','求姐妹们帮我参考一下这个告白方式可不可行！！','我是女生，和暧昧对象去年十月份认识的，后来越来越熟，目前处于每天晚上下班后都会连麦看电影然后互道晚安，或者和他的另一对情侣朋友四个人聚在一起打联机游戏的暧昧阶段（我俩共同爱好就是看电影和打游戏）',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('18','拒绝一个男生之后发现好像又喜欢上他了 ','他是我的一个同事算是，说起来挺有缘份的我们初中高中都是在一个学校，只是当时还不认识。现在在一个单位了，但是算很少能见面的同事，因为业务上算是没什么交集。见他第一印象很好，加上微信之后，他几乎每天都找我聊天，聊了大概两个月，中间也有一起吃过两次饭。但当时我都很确定对他没感觉，所以有天我就微信跟他说清楚了，他也说继续做朋友，之后呢虽然没有天天聊天了，但他也会隔两天三天就找我聊。转折就在最近这一个月他开始不找我了，我突然觉得好失落，还有很多事情想跟他分享，但是他不找我，我觉得我不能主动去找他,毕竟我不确定对他的感觉是喜欢，怕再一次伤害到他，昨天在单位又见到他了我发现跟他说话，看着他我觉得心动，甚至想一直在他身边，我该怎么办家人们',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('19','优秀男女这么多，为什么还是找不到？ ','优秀男女这么多，为什么还是找不到？ ',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('20','女生要不要把自己的家庭情况都和对象说 ','我男朋友刚认识我就一五一十地把他的家庭情况都和我说了，他家庭条件不算好，但是我更看重他这个人怎么样，所以我不是很介意。我的家庭条件也不算好，他也知道我家大致情况，最近突然就在想要不要把我家最彻底的情况都告诉他，因为最最不堪的情况都还没跟他说，怕他介意，又知道他应该不会介意的，因为我们两家都属于家道中落的情况吧，所以感觉在这方面会更理解和包容对方，有种同道中人惺惺相惜的感觉，之前跟他说一些我家的情况他也都说没事，只要我好就好，其他不重要。反正家庭情况改变不了了，父母靠不住，以后人生还长着，那就两个人一起努力，问题也不大。',99,66,23);
insert into Question(id, title, description,  commentcount, viewcount, likecount) values ('21','半个月见一次面没问题吗？ ','有点困扰Emmm 我和男朋友距离二十公里，都在工作且晚上不上班。在一起两年出头目前就半个月一见面dio，不见面都有聊天也有报备，这有问题吗？我一边觉得这样子挺好的，都自由可以干自己的事情，一边好想男人，害',99,66,23);

drop table if exists Comment;
create table Comment
(
    Id         INTEGER PRIMARY KEY AUTOINCREMENT not null,
    Content    TEXT,
    QuestionId TEXT,
    ParentId   INTEGER,
    CreateBy   TEXT,
    CreateAt   DATETIME,
    ModifyAt   DATETIME,
    LikeCount  INTEGER
);

drop table if exists Goods;
create table Goods
(
    Id    TEXT not null,
    Title TEXT,
    Price REAL,
    IsTop INTEGER,
    Url   TEXT,
    Image TEXT,
    Thumb INTEGER,
    CONSTRAINT Pk_Goods primary key (Id)
);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('1','防狼喷雾剂1',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('2','防狼喷雾剂2号',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('3','防狼喷雾剂-粉色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('4','防狼喷雾剂-红色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('5','防狼喷雾剂-蓝色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('6','防狼喷雾剂-黄色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('11','女子防身用品防身手电筒女生随身便携防狼神器尖叫报警器女防狼器女子自卫用品',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('12','【5米远射 可过安检】防狼神器男女生户外防身用品催泪剂洒水剂安防爆自卫喷射洒雾女性随身剂安防保安辣椒 6瓶268质保三年免费换新',99.99,0,'https://item.m.jd.com/product/10030814087245.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('13','【5米远射一秒见效】防狼神器防卫女士用品防护户外喷洒雾女生安全随身剂非辣素 110毫升 效果强劲【免费试用 三年换新】',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('14','防狼神器防卫女士用品防护户外喷洒雾',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('15','110毫升 效果强劲',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('16','尖叫报警器女防狼器女子自卫用品',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
