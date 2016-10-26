/**
 * 
 */
$(document).ready(
		function() {

			$('#addEmp').click(
					function(e) {

						$.ajax({
							datatype : "json",
							headers : {
								accept : "application/json"
							},
							type : "GET",
							url : "ajaxDeptName",

							success : function(msg) {

								$.each(msg, function(k, v) {
									$('#selectDept').append(
											"<option>" + v.deptName
													+ "</option>");

								});

							},
							error : function(e) {
								alert('Error: ' + e);
							}
						});

						$('#empList').css({
							"display" : "inline"
						});

					});

			$('#cancelEmp').click(function(e) {
				$('#empList').css({
					"display" : "none"
				});
			});

			$('#addDept').click(function(e) {
				$('#deptList').css({
					"display" : "inline"
				});
			});

			$('#cancelDept').click(function(e) {
				$('#deptList').css({
					"display" : "none"
				});
			});

			var time = null;

			$('#searchText').keyup(
					function(e) {

						if (time != null) {
							clearTimeout(time);
						}
						time = setTimeout(function() {
							time = null;

							if ($.trim($('#searchText').val()) != '') {
								$.ajax({
									datatype : "json",
									headers : {
										'accept' : "application/json",
										'Content-Type' : 'application/json'
									},
									type : "POST",
									url : "getDeptSearch",
									data : JSON.stringify({
										"deptName" : $('#searchText').val()
									}),

									success : function(msg) {

										$('#textArea').empty();
										$.each(msg, function(k, v) {
											$('#textArea').append(
													"<li><a href='#'>"
															+ v.deptName
															+ "</a></li>");
										});

									},
									error : function(e) {
										console.log('Error: ' + e);
									}
								});
							}
							$('#textArea').empty();
						}, 500);
					});

			$('#fileUpload').on('submit', function(e) {
				e.preventDefault();
	
				var data = new FormData($('#file')[0]); 
				
				console.log(data);
				
				$.ajax({
					type : "post",
					url : "fileUpload",
					data: data,
					processData: false,
					header:{
						'contentType': false
					},
                    cache : false,
					success : function(msg) {

						alert(msg);

					},
					error : function(e) {
						console.log('Error: ' + e);
					}
				});
			});
		});
