//通用js函数js文件

//通用的使用ul定义的一些标签的标签项选中事件
function click_tabSelect(idOful,tabNumForli)
{
		//清除所有的选中状态
		$("#"+ idOful +" li").removeClass("active");
		//激活选中的菜单项
		$("#"+ idOful +" li:eq("+ tabNumForli +")").addClass("active");		
}

//从链接里获取参数方法：
//url有固定的格式，格式为：(主链接)?(参数名1)=(值)&(参数名2)=(值)&……
//要提取某个参数时，需要输入要提取参数的参数名和他的下一个参数的参数名
//形参：要提取参数的参数名，下一个参数的参数名
//返回值：参数值
function getValueFromUrl(UseName,NextName){
		
	var url = window.location.href; //获取url
	var ns = url.indexOf(UseName);	//根据参数名查找开始位置
		
	//如果有下一个参数的话：
	if(!NextName==""){
		var ne = url.indexOf("&"+NextName);	//查找下一个参数名位置
	}
	else{
		var l = url.length;	//如果没有下一个参数，则获取长度
		var val = url.substr(ns+(UseName.length)+1,l);
		val = val.trim();
		val = decodeURI(val); //处理字符编码
		return val;
	}
		
	var val = url.substr(ns+(UseName.length)+1,ne-ns-((UseName.length)+1)); //取参数值,前一个值为参数值开始位置，后一个值为参数值结束位置
	val = decodeURI(val); //处理字符编码
	return val;
}

//在页面使用cmp视频播放器插件（之前需引用相关js文件）
function useVideoPlayer(){
		//避免出错，先判断是否存在视频文件    
		if($('embed').length>0){
	        //获取视频参数，注意播放器的路径    
			var src=$('embed').attr('src'),    
			width=$('embed').attr('width'),    
			height=$('embed').attr('height'),    
			flashvars = {list : '<list><m label="test" src="'+src+'" /></list>'},    
			player = CMP.create("cmp", "100%", "100%", "vplayer/cmpn.swf", flashvars);  
	        //替换embed为播放器  
			$("embed").replaceWith('<div style="width:'+width+'px;height:'+height+'px;margin:0 auto;" id="player">loading ...</div>');    
			$('#player').html(player);    
		}  
	
}