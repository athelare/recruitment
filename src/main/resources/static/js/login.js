;
! function() {
	const layer = layui.layer,
		form = layui.form,
		carousel = layui.carousel;

	const OK=0;

	// 背景图片轮播
	carousel.render({
		elem: '#login_carousel',
		width: '100%',
		height: '100%',
		interval: 3000,
		arrow: 'none',
		anim: 'fade',
		indicator: 'none'
	});

	// 执行获取验证码
	refCode();

	// 点击刷新验证码
	$("#refCode_login_img").on("click", function() {
		refCode();
	});

	// 获取验证码
	function refCode() {
		$.ajax({
			url: "user/getValidateCode",
			type: "post",
			dateType:'json',
			success: function(result) {
				$("#refCode_login_img").prop("src", "data:image/jpg;base64," + result.image);
				$("#code").val("");
			}
		});
	}

	// 自定义验证规则
	form.verify({
		account: function(value) {
			const regUser = /[a-zA-Z0-9]{3,20}$/;
			if(!regUser.test(value.trim())) {
				return "请输入正确的用户名！";
			}
		},
		code: function(value) {
			let res=OK;
			$.ajax({
				url: "user/validate",
				type: "post",
				async:false,
				dateType:'json',
				data:{code:value},
				success: function(result) {
					res=result.status;
				}
			});
			if(res !== OK) {
				refCode();
				return "验证码不正确";
			}
		}
	});

	//监听提交  
	form.on("submit(login)", function() {
		$.ajax({
			url: "/company/login",
			type: "post",
			dataType:"json",
			data: {
				"companyId": $("#account").val(),
				"password": $("#password").val()
			},
			success: function(result) {
				if(result.status === OK) {
					location.href = "C:/Users/Carl/Desktop/frame/index.html";
				} else {
					refCode();
					$("#password").val("");
					layer.alert(result.message, {
						title: '提交结果'
					});
				}
			}
		});

		return false;
	});
}();