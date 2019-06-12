;
! function() {
	var layer = layui.layer,
		form = layui.form;
	const OK = 0;

	// 当勾选不同意协议按钮后禁止注册
	form.on("checkbox(agreen-checkbox)", function(data) {
		let reg=$("#reg");
		if(!data.elem.checked) {
			reg.addClass("layui-btn-disabled");
			reg.prop("disabled", "disabled");
		} else {
			reg.removeClass("layui-btn-disabled");
			reg.removeAttr("disabled");
		}
	});

	// 执行获取验证码
	refCode();

	// 点击刷新验证码
	$("#refCode_reg_img").on("click", function() {
		refCode();
	});

	// 获取图片验证码

	function refCode() {
		$.ajax({
			url: "user/getValidateCode",
			type: "post",
			dateType:'json',
			success: function(result) {
				$("#refCode_reg_img").prop("src", "data:image/jpg;base64," + result.image);
				$("#code").val("");
			}
		});
	}

	// 验证用户名唯一
	let input_username=$('#username');
	function vailUsername() {
		let res=0;
		$.ajax({
			url:"user/testUsername",
			method:"post",
			dataType:"json",
			async:false,
			data:{username:input_username.val()},
			success:result => res=result.status
		});
		return res;
	}

	// 用户名输入框改变时验证
	input_username.on("change", function() {
		if(vailUsername() !== OK) {
			layer.msg("该用户名已被注册", {
				icon: 5
			});
		}
	});

	// 自定义验证规则
	form.verify({
		username: function() {
			if(vailUsername() !== OK) {
				return "该用户名已被注册";
			}
		},
		pwd: function(value) {
			if(value.length < 8) {
				return "密码长度不能少于8位";
			} else if(!/^(\w){8,20}$/.test(value)) {
				return "密码只能包含字母、数字或下划线";
			}
		},
		rePwd: function(value) {
			if(value !== $("#password").val()) {
				return "两次输入的密码不一致";
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
				return "验证码有误";
			}
		},
		email: function(value) {
			let email_pat = /^([A-Za-z0-9_\-.])+@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$/;
			if(!email_pat.test(value)){
				return "邮箱格式错误！";
			}
		}
	});

	//监听提交  
	form.on("submit(register)", function() {
		if(vailUsername() !== OK) {
			layer.msg("该用户名已被注册", {
				icon: 5
			});
		} else {
			$.ajax({
				url: "user/register",
				type: "post",
				dataType:"json",
				contentType:"application/json",
				data: JSON.stringify({
					"username":$("#username").val(),
					"password": $("#password").val(),
					"email":$("#email").val(),
					"nickname":$("#nickname").val()
				}),
				success: function(result) {
					if(result.status === OK) {
						layer.msg("注册成功");
						setTimeout("location='login.html'", 2000);
					} else {
						$("form")[0].reset();
						layer.msg(result.msg, {
							icon: 5
						});
					}
				}
			});
		}

		return false;
	});
}();