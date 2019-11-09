function login(){
				var u_id=document.getElementById("u_id");
				var u_passwd=document.getElementById("u_passwd");
				if(u_id.value==""||u_id.value==null){
					alert("账号不能为空！")
					return;
				}
				if(u_passwd.value==""||u_passwd.value==null){
					alert("密码不能为空！")
				}
			/*	$.ajax({
					url:"http://localhost:8080/login/user",
					dataType: JSON,
					type:'post',
					contentType:"application/json",
					data: {
						uId: '123467',
						uPassword: 'tzg9609'
					},
					async:true,
					success:function(result){
						alert("登录成功 ");
					},
					error:function(){
						alert("error");
					}
				 });*/
		        
			}