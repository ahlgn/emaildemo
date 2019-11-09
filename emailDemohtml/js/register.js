function register(){
	            alert("test");
	            var u_id=document.getElementById("u_id");
				var u_passwd=document.getElementById("u_passwd");
				var reu_passwd=document.getElementById("reu_passwd");
				alert(passed.value+repassed.value);
				if(u_id.value==""||u_id.value==null){
					alert("账号不能为空！")
					return;
				}
				if(u_passwd.value==""||u_passwd.value==null){
					alert("密码不能为空！")
				}
				
				if(u_passwd.value!=reu_passwd.value){
					alert("重复密码不正确");
					return false;
				}
			}