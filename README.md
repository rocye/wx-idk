# wx-idk
微信接口开发包   by Rocye
# 项目说明
本项目是针对微信公众平台接口开发的工具包，旨在方便使用者更快更简单的进行微信公众平台的接口开发。
# 使用说明
项目编译生成的jar包可直接导入相关项目进行调用，具体代码可参照功能列表所对应的单元测试代码中找到。
# 功能列表
## 1.AccessToken缓存
AccessToken是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token，开发者需要进行妥善保存。<br>
本工具包在测试包中提供了三种AccessToken缓存的实现类，都需要实现WxToken接口，使用者可以自定义自己的Token缓存实现。<br>
#### 1）GlobalAccessToken
将AccessToken缓存在全局变量中，只能供当前项目模块调用，项目重启时会被重置。
#### 2）RedisAccessToken
将AccessToken缓存在Redis中，可供多个项目调用，项目重启时不会被重置。
#### 3）ThirdpartyAccessToken
通过第三方接口调用得到的AccessToken缓存在Redis中，主要针对公众平台后台不止一个开发商的情况。
## 2.接口调用示例
调用逻辑由三部分组成：<br>
WxClient：请求客户端通过Token做参数进行<br>
XXXRequest：请求实体主要用于传递请求参数<br>
XXXRespone：响应实体主要用于接收请求返回<br>
具体代码如下：
	
	WxClient wxClient = new WxClient(new RedisAccessToken(APPID, APPSERCT));
	IpListGetRequest ipListGetReq = new IpListGetRequest();
	IpListGetRespone ipListGetRes = wxClient.excute(ipListGetReq);
----
## 3.获取微信服务器IP地址
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN`
#### 本工具包类：IpListGetRequest & IpListGetRespone
## 4.长链接转短链接接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN`
#### 本工具包类：IpListGetRequest & IpListGetRespone
## 5.创建二维码ticket
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN`
#### 本工具包类：QrcodeCreateRequest & QrcodeCreateRespone
## 6.通过ticket换取二维码
#### 原接口地址：`https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET`
#### 本工具包类：ShowQrcodeRequest & ShowQrcodeRespone
## 7.获取公众号的自动回复规则
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN`
#### 本工具包类：CurrentAutoreplyGetRequest & CurrentAutoreplyGetRespone
#### 备注：由于公众号自动回复规则接口返回的JSON串太过复杂，本接口Respone类没有将JSON串转化成属性字段，请自行转化JSON字段：body。
----
## 8.自定义菜单创建接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuCreateRequest & MenuCreateRespone
## 9.自定义菜单查询接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuGetRequest & MenuGetRespone
## 10.自定义菜单删除接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuDeleteRequest & MenuDeleteRespone
----
## 11.创建个性化菜单
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalAddRequest & ConditionalAddRespone
## 12.删除个性化菜单
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalDeleteRequest & ConditionalDeleteRespone
## 13.测试个性化菜单匹配结果
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalTrymatchRequest & ConditionalTrymatchRespone
## 14.查询个性化菜单
#### `同上9`
## 15.删除所有菜单
#### `同上10`
## 16.获取自定义菜单配置接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN`
#### 本工具包类：SelfmenuInfoGetRequest & SelfmenuInfoGetRespone
----
## 17.新增临时素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE`
#### 本工具包类：TempMaterialAddRequest & TempMaterialAddRespone
## 18.新增临时素材（视频素材的第二次上传接口）
#### 原接口地址：`http://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN`
#### 本工具包类：TempVideoAddRequest & TempVideoAddRespone
## 19.获取临时素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID`
#### 本工具包类：TempMaterialGetRequest & TempMaterialGetRespone

## 20.新增永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsAddRequest & NewsAddRespone
## 21.上传图文消息内的图片获取URL
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsInnerImgAddRequest & NewsInnerImgAddRespone
## 22.获取永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsGetRequest & NewsGetRespone
## 23.获取永久图文素材列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsBatGetRequest & NewsBatGetRespone
## 24.修改永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUpdateRequest & NewsUpdateRespone
## 25.上传图文消息素材（用于高级群发接口）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUploadRequest & NewsUploadRespone

## 26.新增其他类型永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE`
#### 本工具包类：PerpetualMaterialAddRequest & PerpetualMaterialAddRespone
## 27.获取其它永久素材（除图文和视频外）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMediaGetRequest & PerpetualMediaGetRespone
## 28.获取永久视频素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualVideoGetRequest & PerpetualVideoGetRespone
## 29.删除永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialDelRequest & PerpetualMaterialDelRespone
## 30.获取永久素材列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialBatGetRequest & PerpetualMaterialBatGetRespone
## 31.获取永久素材总数
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialCountRequest & PerpetualMaterialCountRespone
----
## 32.创建用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsCreateRequest & TagsCreateRespone
## 33.获取公众号已创建的用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsGetRequest & TagsGetRespone
## 34.编辑用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsUpdateRequest & TagsUpdateRespone
## 35.删除用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsDeleteRequest & TagsDeleteRespone
## 36.获取标签下粉丝列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN`
#### 本工具包类：TagUserListGetRequest & TagUserListGetRespone
## 37.批量为用户打标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsMemberBatchTagRequest & TagsMemberBatchTagRespone
## 38.批量为用户取消标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsMemberBatchUntagRequest & TagsMemberBatchUntagRespone
## 39.获取用户身上的标签列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsGetidListRequest & TagsGetidListRespone
----
## 40.设置用户备注名
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN`
#### 本工具包类：UserUpdateRemarkRequest & UserUpdateRemarkRespone
## 41.获取用户基本信息(UnionID机制)
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN`
#### 本工具包类：UserInfoRequest & UserInfoRespone
## 42.批量获取用户基本信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN`
#### 本工具包类：UserInfoBatchGetRequest & UserInfoBatchGetRespone
## 43.获取用户列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID`
#### 本工具包类：UserListGetRequest & UserListGetRespone
----
## 44.获取公众号的黑名单列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BlackListGetRequest & BlackListGetRespone
## 45.拉黑用户
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BatchblackListRequest & BatchblackListRespone
## 46.取消拉黑用户
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BatchunblackListRequest & BatchunblackListRespone
----
## 47.获取用户增减数据（getusersummary）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserSummaryRequest & GetUserSummaryRespone
## 48.获取累计用户数据（getusercumulate）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserCumulateRequest & GetUserCumulateRespone
----
## 49.获取图文群发每日数据（getarticlesummary）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN`
#### 本工具包类：GetArticleSummaryRequest & GetArticleSummaryRespone
## 50.获取图文群发总数据（getarticletotal）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN`
#### 本工具包类：GetArticleTotalRequest & GetArticleTotalRespone
## 51.获取图文统计数据（getuserread）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserReadRequest & GetUserReadRespone
## 52.获取图文统计分时数据（getuserreadhour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserReadHourRequest & GetUserReadHourRespone
## 53.获取图文分享转发数据（getusershare）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserShareRequest & GetUserShareRespone
## 54.获取图文分享转发分时数据（getusersharehour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserShareHourRequest & GetUserShareHourRespone
----
## 55.获取消息发送概况数据（getupstreammsg）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgRequest & GetUpstreamMsgRespone
## 56.获取消息分送分时数据（getupstreammsghour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgHourRequest & GetUpstreamMsgHourRespone
## 57.获取消息发送周数据（getupstreammsgweek）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgWeekRequest & GetUpstreamMsgWeekRespone
## 58.获取消息发送月数据（getupstreammsgmonth）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgMonthRequest & GetUpstreamMsgMonthRespone
## 59.获取消息发送分布数据（getupstreammsgdist）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistRequest & GetUpstreamMsgDistRespone
## 60.获取消息发送分布周数据（getupstreammsgdistweek）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistWeekRequest & GetUpstreamMsgDistWeekRespone
## 61.获取消息发送分布月数据（getupstreammsgdistmonth）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistMonthRequest & GetUpstreamMsgDistMonthRespone
----
## 62.评论能力管理（新增字段：need_open_comment 和 only_fans_can_comment）
### 1.新增永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsAddRequest & NewsAddRespone
##### 新增返回码（json格式）：{"errcode" : 88000, "errmsg" : "without comment privilege"}	//没有留言权限
### 2.获取永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsGetRequest & NewsGetRespone
### 3.修改永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUpdateRequest & NewsUpdateRespone
### 4.获取素材列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsBatGetRequest & NewsBatGetRespone
----
## 63.打开已群发文章评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/open?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentOpenRequest & CommentRespone
## 64.关闭已群发文章评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/close?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentCloseRequest & CommentRespone
## 65.关闭已群发文章评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentListRequest & CommentListRespone
----

