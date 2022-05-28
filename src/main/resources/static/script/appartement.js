$(document)
		.ready(
				function() {
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;

					table = $('#tappartement')
					
							.DataTable({
										ajax : {
											
											url : URL +"appartements/all",
											dataSrc : '',
											type: "GET"
										},
										columns : [
												{
													data : "idAppartement"
												},
												{
													data : "numero"
												},
												{
													data : "etage"
												},
												{
													data : "surface"
												},
												{
													data : "immeuble.nom"
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
					
					$.ajax({
						url:'/immeubles/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.idImmeuble+'>'+e.nom+'</option>';
							});
							
						$('#immeuble').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});

					$('#btn').click(
							function() {
								
								var numero = $("#numero");
								var etage = $("#etage");
								var surface = $("#surface");
								var immeuble = $("#immeuble");
								//if ($('#btn').text() == 'Ajouter') {
									console.log("ttest", immeuble.val())
									var p = {
										numero : numero.val(),
										etage : etage.val(),
										surface : surface.val(),
										immeuble : {
											idImmeuble : parseInt(immeuble.val())
										}
									};
								
									$.ajax({
										url : 'http://localhost:8090/appartements/save',
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
											"./page/appartement.html");
								//}
							});
                       
                       $('#btn1').click(
							function() {
								
								console.log("test")
								var numero = $("#numero");
								var etage = $("#etage");
								var surface = $("#surface");
								var immeuble = $("#immeuble");
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										numero : numero.val(),
										etage : etage.val(),
										surface : surface.val(),
										immeuble : {
											idImmeuble : immeuble.val()
										}
									};

									$.ajax({
											url : URL + 'appartements/edit/' + id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												//table.ajax.reload();
												 
												 $("#numero").val('');
												$("#etage").val('');
												$("#surface").val('');
												$("#immeuble").val('');
												
												btn.text('Ajouter');
												console.log("in")
												table.ajax
														.reload();
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#tappartement").load(
												"./page/appartement.html ");
												
								//}
							});

                       
                       
                       
                       
                       
                       
                       
					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {
										console.log("sup")
										var id = $(this).closest('tr').find(
												'td').eq(0).text();
										
															$
																	.ajax({
																		url :  URL + 'appartements/' + id,
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
																				table.ajax.reload();
																			}
																		},
																		error : function(
																				jqXHR,
																				textStatus,
																				errorThrown) {
																			$(
																					"#error")
																					.modal();
																		}
																	});

														});

									
									
									

					$('#table-content').on(
							'click',
							'.modifier',
							function() {
								console.log("test")
								var btn = $('#btn');
								id = $(this).closest('tr').find('td').eq(0)
										.text();
								
								var numero = $(this).closest('tr').find('td').eq(
										1).text();
								var etage = $(this).closest('tr').find('td')
										.eq(2).text();
								var surface = $(this).closest('tr').find('td')
										.eq(3).text();
								var immeuble = $(this).closest('tr').find('td')
								.eq(4).text();
							
								
								btn.text('Modifier');
								$("#numero").val(numero);
								$("#etage").val(etage);
								$("#surface").val(surface);
								var op = $('#immeuble option').filter(function () { return $(this).html() == immeuble; }).val();
								$("#immeuble").val(op);
								$("#id").val(id);
								
								btn.click(function(e) {
									e.preventDefault();
									var p = {
										id : $("#id").val(),
										numero : $("#numero").val(),
										etage : $("#etage").val(),
										surface : $("#surface").val(),
										immeuble : {
											id : $("#immeuble").val()
											
										}
										
									};
									
							});

					
				});
				
			});

			