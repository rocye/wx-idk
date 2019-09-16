# wx-idk
微信接口开发包   by Rocye
# 项目说明
本项目是针对微信公众平台接口开发的工具包，旨在方便使用者更快更简单的进行微信公众平台的接口开发。
# 安装
## Maven
添加仓库地址：
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
添加依赖：
```xml
<dependency>
    <groupId>com.github.rocye</groupId>
    <artifactId>wx-idk</artifactId>
    <version>1.3.0</version>
</dependency>
```
## Gradle
添加仓库地址：
```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
添加依赖：
```
dependencies {
    compile 'com.github.rocye:wx-idk:1.2.0'
}
```
# 使用说明
安装成功或直接下载jar包导入自己的项目后可进行调用，具体代码可参照功能列表所对应的单元测试代码中找到。
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
#### 1)基础接口调用逻辑由三部分组成：<br>
WxClient：请求客户端需要Token做参数<br>
XXXRequest：请求实体主要用于传递请求参数<br>
XXXRespone：响应实体主要用于接收请求返回<br>
示例代码如下：
```
WxClient wxClient = new WxClient(new RedisAccessToken(APPID, APPSERCT));
IpListGetRequest ipListGetReq = new IpListGetRequest();
IpListGetRespone ipListGetRes = wxClient.excute(ipListGetReq);
```
#### 2)支付接口调用逻辑由三部分组成：<br>
WxPayClient：请求客户端需要商户API密钥、证书及密码做参数<br>
XXXRequest：请求实体主要用于传递请求参数<br>
XXXRespone：响应实体主要用于接收请求返回<br>
示例代码如下：
```
WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
GetQyTransferinfoRequest getQyTransferinfoReq = new GetQyTransferinfoRequest(nonceStr, AppId, MchId, partnerTradeNo);
GetQyTransferinfoRespone getQyTransferinfoRes = wxPayClient.excute(getQyTransferinfoReq);
```
----
## 3.获取微信服务器IP地址
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN`
#### 本工具包类：IpListGetRequest & IpListGetRespone
## 4.长链接转短链接接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN`
#### 本工具包类：Long2ShortUrlRequest & Long2ShortUrlRespone
## 5.创建二维码ticket
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN`
#### 本工具包类：QrcodeCreateRequest & QrcodeCreateRespone
## 6.通过ticket换取二维码
#### 原接口地址：`https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET`
#### 本工具包类：ShowQrcodeRequest & ShowQrcodeRespone
## 7.获取公众号的自动回复规则
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN`
#### 本工具包类：CurrentAutoreplyGetRequest & CurrentAutoreplyGetRespone
##### 备注：由于公众号自动回复规则接口返回的JSON串太过复杂，本接口Respone类没有将JSON串转化成属性字段，请自行转化JSON字段：body。
----
## 8.菜单管理
### 01).自定义菜单创建接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuCreateRequest & MenuCreateRespone
### 02).自定义菜单查询接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuGetRequest & MenuGetRespone
### 03).自定义菜单删除接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：MenuDeleteRequest & MenuDeleteRespone

### 04).创建个性化菜单
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalAddRequest & ConditionalAddRespone
### 05).删除个性化菜单
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalDeleteRequest & ConditionalDeleteRespone
### 06).测试个性化菜单匹配结果
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN`
#### 本工具包类：ConditionalTrymatchRequest & ConditionalTrymatchRespone
### 07).查询个性化菜单
#### `同上2`
### 08).删除所有菜单
#### `同上3`
### 09).获取自定义菜单配置接口
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN`
#### 本工具包类：SelfmenuInfoGetRequest & SelfmenuInfoGetRespone
----
## 9.素材管理
### 01).新增临时素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE`
#### 本工具包类：TempMaterialAddRequest & TempMaterialAddRespone
### 02).新增临时素材（视频素材的第二次上传接口）
#### 原接口地址：`http://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN`
#### 本工具包类：TempVideoAddRequest & TempVideoAddRespone
### 03).获取临时素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID`
#### 本工具包类：TempMaterialGetRequest & TempMaterialGetRespone

### 04).新增永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsAddRequest & NewsAddRespone
### 05).上传图文消息内的图片获取URL（用于高级群发接口）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsInnerImgAddRequest & NewsInnerImgAddRespone
### 06).获取永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsGetRequest & NewsGetRespone
### 07).获取永久图文素材列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsBatGetRequest & NewsBatGetRespone
### 08).修改永久图文素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUpdateRequest & NewsUpdateRespone
### 09).上传图文消息素材（用于高级群发接口）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUploadRequest & NewsUploadRespone

### 10).新增其他类型永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE`
#### 本工具包类：PerpetualMaterialAddRequest & PerpetualMaterialAddRespone
### 11).获取其它永久素材（除图文和视频外）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMediaGetRequest & PerpetualMediaGetRespone
### 12).获取永久视频素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualVideoGetRequest & PerpetualVideoGetRespone
### 13).删除永久素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialDelRequest & PerpetualMaterialDelRespone
### 14).获取永久素材列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialBatGetRequest & PerpetualMaterialBatGetRespone
### 15).获取永久素材总数
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN`
#### 本工具包类：PerpetualMaterialCountRequest & PerpetualMaterialCountRespone
----
## 10.用户管理
### 01).创建用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsCreateRequest & TagsCreateRespone
### 02).获取公众号已创建的用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsGetRequest & TagsGetRespone
### 03).编辑用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsUpdateRequest & TagsUpdateRespone
### 04).删除用户标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsDeleteRequest & TagsDeleteRespone
### 05).获取标签下粉丝列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN`
#### 本工具包类：TagUserListGetRequest & TagUserListGetRespone
### 06).批量为用户打标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsMemberBatchTagRequest & TagsMemberBatchTagRespone
### 07).批量为用户取消标签
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsMemberBatchUntagRequest & TagsMemberBatchUntagRespone
### 08).获取用户身上的标签列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN`
#### 本工具包类：TagsGetidListRequest & TagsGetidListRespone

### 09).设置用户备注名
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN`
#### 本工具包类：UserUpdateRemarkRequest & UserUpdateRemarkRespone
### 10).获取用户基本信息(UnionID机制)
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN`
#### 本工具包类：UserInfoRequest & UserInfoRespone
### 11).批量获取用户基本信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN`
#### 本工具包类：UserInfoBatchGetRequest & UserInfoBatchGetRespone
### 12).获取用户列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID`
#### 本工具包类：UserListGetRequest & UserListGetRespone

### 13).获取公众号的黑名单列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BlackListGetRequest & BlackListGetRespone
### 14).拉黑用户
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BatchblackListRequest & BatchblackListRespone
### 15).取消拉黑用户
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN`
#### 本工具包类：BatchunblackListRequest & BatchunblackListRespone
----
## 11.数据统计
### 01).获取用户增减数据（getusersummary）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserSummaryRequest & GetUserSummaryRespone
### 02).获取累计用户数据（getusercumulate）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserCumulateRequest & GetUserCumulateRespone

### 03).获取图文群发每日数据（getarticlesummary）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN`
#### 本工具包类：GetArticleSummaryRequest & GetArticleSummaryRespone
### 04).获取图文群发总数据（getarticletotal）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN`
#### 本工具包类：GetArticleTotalRequest & GetArticleTotalRespone
### 05).获取图文统计数据（getuserread）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserReadRequest & GetUserReadRespone
### 06).获取图文统计分时数据（getuserreadhour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserReadHourRequest & GetUserReadHourRespone
### 07).获取图文分享转发数据（getusershare）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserShareRequest & GetUserShareRespone
### 08).获取图文分享转发分时数据（getusersharehour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUserShareHourRequest & GetUserShareHourRespone

### 09).获取消息发送概况数据（getupstreammsg）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgRequest & GetUpstreamMsgRespone
### 10).获取消息分送分时数据（getupstreammsghour）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgHourRequest & GetUpstreamMsgHourRespone
### 11).获取消息发送周数据（getupstreammsgweek）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgWeekRequest & GetUpstreamMsgWeekRespone
### 12).获取消息发送月数据（getupstreammsgmonth）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgMonthRequest & GetUpstreamMsgMonthRespone
### 13).获取消息发送分布数据（getupstreammsgdist）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistRequest & GetUpstreamMsgDistRespone
### 14).获取消息发送分布周数据（getupstreammsgdistweek）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistWeekRequest & GetUpstreamMsgDistWeekRespone
### 15).获取消息发送分布月数据（getupstreammsgdistmonth）
#### 原接口地址：`https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN`
#### 本工具包类：GetUpstreamMsgDistMonthRequest & GetUpstreamMsgDistMonthRespone
----
## 12.发送消息—客服消息
### 01).客服接口之发送文本消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN`
#### 本工具包类：KfSendTextRequest & KfSendRespone
### 02).客服接口之发送图片消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN`
#### 本工具包类：KfSendImageRequest & KfSendRespone
### 03).客服接口之发送语音消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN`
#### 本工具包类：KfSendVoiceRequest & KfSendRespone
### 04).客服接口之发送视频消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN`
#### 本工具包类：KfSendVideoRequest & KfSendRespone
### 05).客服接口之发送图文消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN`
#### 本工具包类：KfSendMpnewsRequest & KfSendRespone
### 06).客服接口之客服输入状态
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token=ACCESS_TOKEN`
#### 本工具包类：KfTypingRequest & KfSendRespone
----
## 13.发送消息—群发接口和原创校验
### 01).根据标签进行群发之发送文本消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagTextRequest & MassSendRespone
### 02).根据标签进行群发之发送图片消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagImageRequest & MassSendRespone
### 03).根据标签进行群发之发送语音消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagVoiceRequest & MassSendRespone
### 04).根据标签进行群发之发送视频消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagMpvideoRequest & MassSendRespone
### 05).根据标签进行群发之发送图文消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagMpnewsRequest & MassSendRespone
### 06).根据标签进行群发之发送卡券消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendTagWxcardRequest & MassSendRespone

### 07).根据OpenID列表群发之发送文本消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidTextRequest & MassSendRespone
### 08).根据OpenID列表群发之发送图片消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidImageRequest & MassSendRespone
### 09).根据OpenID列表群发之发送语音消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidVoiceRequest & MassSendRespone
### 10).根据OpenID列表群发之发送视频消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidMpvideoRequest & MassSendRespone
### 11).根据OpenID列表群发之发送图文消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidMpnewsRequest & MassSendRespone
### 12).根据OpenID列表群发之发送卡券消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendOpenidWxcardRequest & MassSendRespone
----
## 14.发送消息—删除群发
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendDeleteRequest & MassSendDeleteRespone
----
## 15.发送消息—查询群发消息发送状态
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSendGetRequest & MassSendGetRespone
----
## 16.发送消息—预览接口
### 01).预览接口之文本消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewTextRequest & MassPreviewRespone
### 02).预览接口之图片消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewImageRequest & MassPreviewRespone
### 03).预览接口之语音消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewVoiceRequest & MassPreviewRespone
### 04).预览接口之视频消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewMpvideoRequest & MassPreviewRespone
### 05).预览接口之图文消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewMpnewsRequest & MassPreviewRespone
### 06).预览接口之卡券消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN`
#### 本工具包类：MassPreviewWxcardRequest & MassPreviewRespone
----
## 17.发送消息—控制群发速度
### 01).获取群发速度
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/speed/get?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSpeedGetRequest & MassSpeedGetRespone
### 02).设置群发速度
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token=ACCESS_TOKEN`
#### 本工具包类：MassSpeedSetRequest & MassSpeedSetRespone
----
## 18.发送消息—模板消息
### 01).设置所属行业
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateSetIndustryRequest & TemplateSetIndustryRespone
### 02).获取设置的行业信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateGetIndustryRequest & TemplateGetIndustryRespone
### 03).获得模板ID
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateGetIdRequest & TemplateGetIdRespone
### 04).获取模板列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateGetAllPrivateRequest & TemplateGetAllPrivateRespone
### 05).删除模板
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateDelPrivateRequest & TemplateDelPrivateRespone
### 06).发送模板消息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateSendRequest & TemplateSendRespone
### 07).通过API推送订阅模板消息给到授权微信用户
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=ACCESS_TOKEN`
#### 本工具包类：TemplateSubscribeRequest & TemplateSubscribeRespone
----
## 19.评论能力管理（新增字段：need_open_comment 和 only_fans_can_comment）
### 01).新增永久素材（原接口有所改动）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsAddRequest & NewsAddRespone
##### 新增返回码（json格式）：{"errcode" : 88000, "errmsg" : "without comment privilege"}	//没有留言权限
### 02).获取永久素材（原接口有所改动）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsGetRequest & NewsGetRespone
### 03).修改永久图文素材（原接口有所改动）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsUpdateRequest & NewsUpdateRespone
### 04).获取素材列表（原接口有所改动）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN`
#### 本工具包类：NewsBatGetRequest & NewsBatGetRespone
----
## 20.评论能力管理
### 01).打开已群发文章评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/open?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentOpenRequest & CommentRespone
### 02).关闭已群发文章评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/close?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentCloseRequest & CommentRespone
### 03).查看指定文章的评论数据
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentListRequest & CommentListRespone
### 04).将评论标记精选
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/markelect?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentMarkelectRequest & CommentRespone
### 05).将评论取消精选
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/unmarkelect?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentUnmarkelectRequest & CommentRespone
### 06).删除评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentDeleteRequest & CommentRespone
### 07).回复评论
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/reply/add?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentReplyAddRequest & CommentRespone
### 08).删除回复
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/comment/reply/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：CommentReplyDeleteRequest & CommentRespone
----
## 21.微信门店接口
### 01).创建门店
#### 原接口地址：`http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=TOKEN`
#### 本工具包类：AddPoiRequest & AddPoiRespone
### 02).查询门店信息
#### 原接口地址：`http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=TOKEN`
#### 本工具包类：GetPoiRequest & GetPoiRespone
### 03).查询门店列表
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=TOKEN`
#### 本工具包类：GetPoiListRequest & GetPoiListRespone
### 04).修改门店服务信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=TOKEN`
#### 本工具包类：UpdatePoiRequest & UpdatePoiRespone
### 05).删除门店
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=TOKEN`
#### 本工具包类：DelPoiRequest & DelPoiRespone
### 06).门店类目表
#### 原接口地址：`http://api.weixin.qq.com/cgi-bin/poi/getwxcategory?access_token=TOKEN`
#### 本工具包类：GetPoiCategoryRequest & GetPoiCategoryRespone
----
## 22.新版客服管理接口
### 01).添加客服帐号
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountAddRequest & KfAccountRespone
### 02).修改客服帐号
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountUpdateRequest & KfAccountRespone
### 03).删除客服帐号
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountDelRequest & KfAccountRespone
### 04).设置客服帐号的头像
#### 原接口地址：`http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT`
#### 本工具包类：KfUploadHeadimgRequest & KfAccountRespone
### 05).获取所有客服账号
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountListRequest & KfAccountListRespone
### 06).获取在线客服基本信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountOnlineListRequest & KfAccountOnlineListRespone
### 07).邀请绑定客服帐号
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=ACCESS_TOKEN`
#### 本工具包类：KfAccountInviteworkerRequest & KfAccountRespone
----
## 23.会话控制接口
### 01).创建会话
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfsession/create?access_token=ACCESS_TOKEN`
#### 本工具包类：KfsessionCreateRespone & KfsessionCreateRespone
### 02).修改客服帐号
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfsession/close?access_token=ACCESS_TOKEN`
#### 本工具包类：KfsessionCloseRequest & KfsessionCloseRespone
### 03).获取客户会话状态
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=ACCESS_TOKEN&openid=OPENID`
#### 本工具包类：KfsessionGetRequest & KfsessionGetRespone
### 04).获取客服会话列表
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT`
#### 本工具包类：KfsessionListRequest & KfsessionListRespone
### 05).获取未接入会话列表
#### 原接口地址：`https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=ACCESS_TOKEN`
#### 本工具包类：KfsessionWaitcaseListRequest & KfsessionWaitcaseListRespone
### 06).获取聊天记录
#### 原接口地址：`https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=ACCESS_TOKEN`
#### 本工具包类：KfMsgrecordListRequest & KfMsgrecordListRespone
----
## 24.Wi-Fi门店管理
### 01).获取Wi-Fi门店列表
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/shop/list?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiShopListRequest & WifiShopListRespone
### 02).查询门店Wi-Fi信息
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/shop/get?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiShopGetRequest & WifiShopGetRespone
### 03).修改门店网络信息
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/shop/update?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiShopUpdateRequest & WifiShopUpdateRespone
### 04).清空门店网络及设备
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/shop/clean?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiShopCleanRequest & WifiShopCleanRespone
----
## 25.Wi-Fi设备管理
### 01).添加密码型设备
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/device/add?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiDeviceAddRequest & WifiDeviceAddRespone
### 02).添加portal型设备
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/apportal/register?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiApportalRegisterRequest & WifiApportalRegisterRespone
### 03).查询设备
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/device/list?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiDeviceListRequest & WifiDeviceListRespone
### 04).删除设备
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/device/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiDeviceDeleteRequest & WifiDeviceDeleteRespone
----
## 26.获取物料二维码
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/qrcode/get?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiQrcodeGetRequest & WifiQrcodeGetRespone
----
## 27.商家主页管理
### 01).设置商家主页
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/homepage/set?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiHomepageSetRequest & WifiHomepageSetRespone
### 02).查询商家主页
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/homepage/get?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiHomepageGetRequest & WifiHomepageGetRespone
### 03).设置微信首页欢迎语
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/bar/set?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiBarSetRequest & WifiBarSetRespone
### 04).设置连网完成页
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/finishpage/set?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiFinishpageSetRequest & WifiFinishpageSetRespone
----
## 28.Wi-Fi数据统计
#### 原接口地址：`https://api.weixin.qq.com/bizwifi/statistics/list?access_token=ACCESS_TOKEN`
#### 本工具包类：WifiStatisticsListRequest & WifiStatisticsListRespone
----
## 30.微信支付开发
### 01).【现金红包】发放普通红包
#### 原接口地址：`https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack`
#### 本工具包类：SendRedpackRequest & SendRedpackRespone
### 02).【现金红包】发放裂变红包
#### 原接口地址：`https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack`
#### 本工具包类：SendGroupRedpackRequest & SendRedpackRespone
### 03).【现金红包】查询红包记录
#### 原接口地址：`https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo`
#### 本工具包类：GetRedpackInfoRequest & GetRedpackInfoRespone

### 04).【企业付款】企业付款到零钱
#### 原接口地址：`https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers`
#### 本工具包类：QyTransfersRequest & QyTransfersRespone
### 05).【企业付款】查询企业付款到零钱
#### 原接口地址：`https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo`
#### 本工具包类：GetQyTransferinfoRequest & GetQyTransferinfoRespone
----
## 31.微信开放平台
### 01).【第三方平台】获取第三方平台component_access_token
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_component_token`
#### 本工具包类：ApiComponentTokenRequest & ApiComponentTokenRespone
### 02).【第三方平台】获取预授权码pre_auth_code
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiCreatePreauthcodeRequest & ApiCreatePreauthcodeRespone
### 03).【第三方平台】使用授权码换取公众号或小程序的接口调用凭据和授权信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiQueryAuthRequest & ApiQueryAuthRespone
### 04).【第三方平台】获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiAuthorizerTokenRequest & ApiAuthorizerTokenRespone
### 05).【第三方平台】获取授权方的帐号基本信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiGetAuthorizerInfoRequest & ApiGetAuthorizerInfoRespone
### 06).【第三方平台】获取授权方的选项设置信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_option?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiGetAuthorizerOptionRequest & ApiGetAuthorizerOptionRespone
### 07).【第三方平台】设置授权方的选项信息
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/component/api_set_authorizer_option?component_access_token=ACCESS_TOKEN`
#### 本工具包类：ApiSetAuthorizerOptionRequest & ApiSetAuthorizerOptionRespone
----
## 32.微信卡券
### 01).上传卡券图片素材
#### 原接口地址：`https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN`
#### 本工具包类：CardImgUploadRequest & CardImgUploadRespone
### 02).创建卡券
#### 原接口地址：`https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCreateRequest & CardCreateRespone
### 03).设置买单接口
#### 原接口地址：`https://api.weixin.qq.com/card/paycell/set?access_token=ACCESS_TOKEN`
#### 本工具包类：CardPayCellSetRequest & CardPayCellSetRespone
### 04).设置自助核销接口
#### 原接口地址：`https://api.weixin.qq.com/card/selfconsumecell/set?access_token=ACCESS_TOKEN`
#### 本工具包类：CardSelfconsumeCellSetRequest & CardSelfconsumeCellSetRespone
### 05).创建二维码接口
#### 原接口地址：`https://api.weixin.qq.com/card/qrcode/create?access_token=ACCESS_TOKEN`
#### 本工具包类：(CardQrcodeCreateRequest & CardMultiQrcodeCreateRequest) & CardQrcodeCreateRespone
### 06).创建货架接口
#### 原接口地址：`https://api.weixin.qq.com/card/landingpage/create?access_token=ACCESS_TOKEN`
#### 本工具包类：CardLandingPageCreateRequest & CardLandingPageCreateRespone
### 07).导入code接口
#### 原接口地址：`http://api.weixin.qq.com/card/code/deposit?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeDepositRequest & CardCodeDepositRespone
### 08).查询导入code数目接口
#### 原接口地址：`http://api.weixin.qq.com/card/code/getdepositcount?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeGetDepositCountRequest & CardCodeGetDepositCountRespone
### 09).核查code接口
#### 原接口地址：`http://api.weixin.qq.com/card/code/checkcode?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeCheckRequest & CardCodeCheckRespone
### 10).获取图文消息群发卡券代码
#### 原接口地址：`https://api.weixin.qq.com/card/mpnews/gethtml?access_token=ACCESS_TOKEN`
#### 本工具包类：CardMpnewsGetHtmlRequest & CardMpnewsGetHtmlRespone
### 11).设置测试白名单
#### 原接口地址：`https://api.weixin.qq.com/card/testwhitelist/set?access_token=ACCESS_TOKEN`
#### 本工具包类：CardTestwhitelistSetRequest & CardTestwhitelistSetRespone
----
### 核销/管理卡券
### 13).查询Code接口
#### 原接口地址：`https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeGetRequest & CardCodeGetRespone
### 14).核销Code接口
#### 原接口地址：`https://api.weixin.qq.com/card/code/consume?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeConsumeRequest & CardCodeConsumeRespone
### 15).Code解码接口
#### 原接口地址：`https://api.weixin.qq.com/card/code/decrypt?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeDecryptRequest & CardCodeDecryptRespone
### 16).获取用户已领取卡券接口
#### 原接口地址：`https://api.weixin.qq.com/card/user/getcardlist?access_token=ACCESS_TOKEN`
#### 本工具包类：CardUserGetCardListRequest & CardUserGetCardListRespone
### 17).查看卡券详情
#### 原接口地址：`https://api.weixin.qq.com/card/get?access_token=ACCESS_TOKEN`
#### 本工具包类：CardGetRequest & CardGetRespone
### 18).批量查询卡券列表
#### 原接口地址：`https://api.weixin.qq.com/card/batchget?access_token=ACCESS_TOKEN`
#### 本工具包类：CardBatchGetRequest & CardBatchGetRespone
### 19).更改卡券信息接口
#### 原接口地址：`https://api.weixin.qq.com/card/update?access_token=ACCESS_TOKEN`
#### 本工具包类：CardUpdateRequest & CardUpdateRespone
### 20).修改库存接口
#### 原接口地址：`https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN`
#### 本工具包类：CardModifyStockRequest & CardModifyStockRespone
### 21).更改Code接口
#### 原接口地址：`https://api.weixin.qq.com/card/code/update?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeUpdateRequest & CardCodeUpdateRespone
### 22).删除卡券接口
#### 原接口地址：`https://api.weixin.qq.com/card/delete?access_token=ACCESS_TOKEN`
#### 本工具包类：CardDeleteRequest & CardDeleteRespone
### 23).设置卡券失效接口
#### 原接口地址：`https://api.weixin.qq.com/card/code/unavailable?access_token=ACCESS_TOKEN`
#### 本工具包类：CardCodeUnavailableRequest & CardCodeUnavailableRespone
----
### 统计卡券数据
### 24).拉取卡券概况数据接口
#### 原接口地址：`https://api.weixin.qq.com/datacube/getcardbizuininfo?access_token=ACCESS_TOKEN`
#### 本工具包类：GetCardBizuininfoRequest & GetCardBizuininfoRespone
### 25).获取免费券数据接口
#### 原接口地址：`https://api.weixin.qq.com/datacube/getcardcardinfo?access_token=ACCESS_TOKEN`
#### 本工具包类：GetCardCardinfoRequest & GetCardCardinfoRespone
### 26).拉取会员卡概况数据接口
#### 原接口地址：`https://api.weixin.qq.com/datacube/getcardmembercardinfo?access_token=ACCESS_TOKEN`
#### 本工具包类：GetCardMemberCardinfoRequest & GetCardMemberCardinfoRespone
### 27).拉取单张会员卡数据接口
#### 原接口地址：`https://api.weixin.qq.com/datacube/getcardmembercarddetail?access_token=ACCESS_TOKEN`
#### 本工具包类：GetCardMemberCarddetailRequest & GetCardMemberCarddetailRespone
----


