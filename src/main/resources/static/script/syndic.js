$(document)
		.ready(
				function() {
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;

					table = $('#tpersonne')
							.DataTable({
										ajax : {
											url :URL +"personnes/all",
											
											dataSrc : '',
											type: "GET"
										},
										columns : [
												{
													data : "idPersonne"
												},
												
												{
													data : "nom"
												},
												{
													data : "prenom"
												},
												{
													data : "email"
												},
												{
													data : "password"
												},
												
												{
													data : "tel"
												},
												{
													data : "ville"
												},
												
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
													}
												},
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-secondary modifier">Affiche</button>';
													}
												} ]

									});
					
					

					$('#btn').click(
							function() {
								console.log("btn")
								var nom = $("#nom");
								var prenom = $("#prenom");
								var email = $("#email");
								var password = $("#password");
								var tel = $("#tel");
								var ville = $("#ville");
								
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										nom : nom.val(),
										prenom : prenom.val(),
										email : email.val(),
										password: password.val(),
										tel : tel.val(), 
										ville : ville.val(),
										
										
									};

									$.ajax({
										url : 'http://localhost:8090/personnes/save',
										contentType : "application/json",
										dataType : "json",
										data : JSON.stringify(p),
										type : 'POST',
										async : false,
										success : function(data, textStatus,
												jqXHR) {
											table.ajax.reload();
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.log(textStatus);
										}
									});
									$("#main-content").load(
											"./page/syndic.html");
								//}
							});


							$('#btn1').click(
							function() {
								
								console.log("test")
								var nom = $("#nom");
								var prenom = $("#prenom");
								var email = $("#email");
								var password = $("#password");
								var tel = $("#tel");
								var ville = $("#ville");
								
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										nom : nom.val(),
										prenom : prenom.val(),
										email : email.val(),
										password: password.val(),
										tel : tel.val(), 
										ville : ville.val(),
									};

									$.ajax({
											url : URL + 'personnes/edit/' + id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												table.ajax.reload();
												 
												 $("#nom").val(''),
								 				 $("#prenom").val(''),
								 				 $("#email").val(''),
								 				 $("#password").val(''),
								 				 $("#tel").val(''),
								 				 $("#ville").val('');
								 				 
												
												btn.text('Ajouter');
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#main-content").load(
												"./page/syndic.html");
								//}
							});

					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {

										var id = $(this).closest('tr').find(
												'td').eq(0).text();
												
												$
																	.ajax({
																		url : URL + 'personnes/' + id,
																		data : {},
																		type : 'DELETE',
																		async : false,
																		success : function(
																				data,
																				textStatus,
																				jqXHR) {
																			if (data
																					.includes("error") == true) {
																				$(
																						"#error")
																						.modal();
																			} else {
																				table.ajax
																						.reload();
																			}
																		},
																		
																	});
										

										
										
									});

					$('#table-content').on(
							'click',
							'.modifier',
							function() {
								
								var btn = $('#btn');
								id = $(this).closest('tr').find('td').eq(0)
										.text();
								
								var nom = $(this).closest('tr').find('td')
										.eq(1).text();
								var prenom = $(this).closest('tr').find('td')
										.eq(2).text();
								var email = $(this).closest('tr').find('td')
										.eq(3).text();				
								var password = $(this).closest('tr').find('td').eq(
										4).text();
								var tel = $(this).closest('tr').find('td')
										.eq(5).text();
								
								var ville = $(this).closest('tr').find('td')
								.eq(6).text();
								
							
								
								btn.text('Modifier');
								
								 $("#nom").val(nom),
								 $("#prenom").val(prenom),
								 $("#email").val(email),
								 $("#password").val(password),
								 $("#tel").val(tel),
								$("#ville").val(ville),
								$("#id").val(id);
								console.log("mod1")
								btn.click(function(e) {
									console.log("mod2")
									e.preventDefault();
									p = {
										id : $("#id").val(),
									
										nom :  $("#nom").val(nom),
								 		prenom : $("#prenom").val(prenom),
										email : $("#email").val(email),
										password : $("#password").val(password),
										tel : $("#tel").val(tel),
										ville :$("#ville").val(ville),
										
										
									};
									//if ($('#btn').text() == 'Modifier') {
										
									//}
								});
							});
});
					
			
				
