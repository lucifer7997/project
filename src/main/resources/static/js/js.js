$(document).ready(function() {
	var urlHome = 'http://localhost:8080/'

	$('#table').DataTable({
		"lengthMenu": [[5, 15, 20, 25, -1], [5, 15, 20, 25, "All"]]
	});

	$('#emp-update').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect > 1) {
			alert('You only select one row!')
		} else {
			if (numberOfRowSelect == 1) {
				$('input:checked').each(function() {
					var row = [];

					// Enumerate over all td elements in the parent tr,
					// skipping the first one (which contains just the
					// checkbox).
					$(this).closest('tr').find('td:not(:first-child)').each(function() {
						// Gather the text into row
						row.push($(this).text());
					});

					// JSONify for easy display
					var url = urlHome + "home/employee/update/"
					window.location.href = url + row[0]
				});


			} else {
				alert('You must select one row!')
			}
		}
	});

	$('#emp-delete').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect >= 1) {
			$.confirm({
				title: 'Confirm!',
				content: 'Are sure want to delete ' + numberOfRowSelect + ' employee?',
				buttons: {
					confirm: function() {
						var ids = [];
						$('input:checked').each(function() {
							var row = [];
							// Enumerate over all td elements in the parent tr,
							// skipping the first one (which contains just the
							// checkbox).
							$(this).closest('tr').find('td:not(:first-child)').each(function() {
								// Gather the text into row
								row.push($(this).text());
							});
							ids.push(row[0]);
						});
						// JSONify for easy display
						var url = urlHome + "home/employee/delete?"
						for (let i = 0; i < ids.length; i++) {
							url = url + 'id=' + ids[i] + '&';
						}
						window.location.href = url;
						$.alert('Deleted!');
					},
					cancel: function() {
					}
				}
			});
		} else {
			alert('You must select at least one row!')
		}
	});

	$("#checkAll").click(function() {
		$(".check").prop('checked', $(this).prop('checked'));
	});

	$('#vaccine-type-update').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect > 1) {
			alert('You only select one row!')
		} else {
			if (numberOfRowSelect == 1) {
				$('input:checked').each(function() {
					var row = [];
					// Enumerate over all td elements in the parent tr,
					// skipping the first one (which contains just the
					// checkbox).
					$(this).closest('tr').find('td:not(:first-child)').each(function() {
						// Gather the text into row
						row.push($(this).text());
					});
					// JSONify for easy display
					var url = urlHome + "home/vaccine-type/update/"
					window.location.href = url + row[0]
				});
			} else {
				alert('You must select one row!')
			}
		}
	});

	$('#vaccine-type-delete').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect >= 1) {
			$.confirm({
				title: 'Confirm!',
				content: 'Are sure want to delete ' + numberOfRowSelect + ' vaccinetype?',
				buttons: {
					confirm: function() {
						var ids = [];
						$('input:checked').each(function() {
							var row = [];
							// Enumerate over all td elements in the parent tr,
							// skipping the first one (which contains just the
							// checkbox).
							$(this).closest('tr').find('td:not(:first-child)').each(function() {
								// Gather the text into row
								row.push($(this).text());
							});
							ids.push(row[0]);
						});
						// JSONify for easy display
						var url = urlHome + "home/vaccine-type/delete?"
						for (let i = 0; i < ids.length; i++) {
							url = url + 'id=' + ids[i] + '&';
						}
						window.location.href = url;
						$.alert('Deleted!');
					},
					cancel: function() {
					}
				}
			});
		} else {
			alert('You must select at least one row!')
		}
	});

	$('#vaccine-schedule-update').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect > 1) {
			alert('You only select one row!')
		} else {
			if (numberOfRowSelect == 1) {
				$('input:checked').each(function() {
					var row = [];
					// Enumerate over all td elements in the parent tr,
					// skipping the first one (which contains just the
					// checkbox).
					$(this).closest('tr').find('td:not(:first-child)').each(function() {
						// Gather the text into row
						row.push($(this).text());
					});
					// JSONify for easy display
					var url = urlHome + "home/vaccine-schedule/update/"
					window.location.href = url + row[0]
				});
			} else {
				alert('You must select one row!')
			}
		}
	});

	$('#customer-delete').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect >= 1) {
			$.confirm({
				title: 'Confirm!',
				content: 'Are sure want to delete ' + numberOfRowSelect + ' customer?',
				buttons: {
					confirm: function() {
						var ids = [];
						$('input:checked').each(function() {
							var row = [];
							// Enumerate over all td elements in the parent tr,
							// skipping the first one (which contains just the
							// checkbox).
							$(this).closest('tr').find('td:not(:first-child)').each(function() {
								// Gather the text into row
								row.push($(this).text());
							});
							ids.push(row[0]);
						});
						// JSONify for easy display
						var url = "http://localhost:8080/home/customer/delete?"
						for (let i = 0; i < ids.length; i++) {
							url = url + 'id=' + ids[i] + '&';
						}
						window.location.href = url;
						$.alert('Deleted!');
					},
					cancel: function() {
					}
				}
			});
		} else {
			alert('You must select at least one row!')
		}
	});


	$('#vaccine-update').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect > 1) {
			alert('You only select one row!')
		} else {
			if (numberOfRowSelect == 1) {
				$('input:checked').each(function() {
					var row = [];
					// Enumerate over all td elements in the parent tr,
					// skipping the first one (which contains just the
					// checkbox).
					$(this).closest('tr').find('td:not(:first-child)').each(function() {
						// Gather the text into row
						row.push($(this).text());
					});
					// JSONify for easy display
					var url = urlHome + "home/vaccine/update/"
					window.location.href = url + row[0]
				});
			} else {
				alert('You must select one row!')
			}
		}
	});

	$('#vaccine-inactive').click(function() {
		var numberOfRowSelect = $(":checkbox:checked").length;
		if ($("#checkAll").prop('checked') == true) {
			numberOfRowSelect = numberOfRowSelect - 1;
		}
		if (numberOfRowSelect >= 1) {
			$.confirm({
				title: 'Confirm!',
				content: 'Are sure to make in-active? ',
				buttons: {
					confirm: function() {
						var ids = [];
						var status = [];
						$('input:checked').each(function() {
							var row = [];
							// Enumerate over all td elements in the parent tr,
							// skipping the first one (which contains just the
							// checkbox).
							$(this).closest('tr').find('td:not(:first-child)').each(function() {
								// Gather the text into row
								row.push($(this).text());
							});
							ids.push(row[0]);
							status.push(row[5]);
						});
						var count = 0;
						// JSONify for easy display
						for (let i = 0; i < status.length; i++) {
							if (status[i] == "In-Actived") {
								count = count + 1;

							}
						}
						if (count == 0) {
							var url = urlHome + "home/vaccine/inactive?"
							for (let i = 0; i < ids.length; i++) {
								url = url + 'id=' + ids[i] + '&';
							}
							window.location.href = url;
							$.alert('In-Actived!');
						} else {
							$.alert('Invalid data - please recheck your selects!');
						}
					},
					cancel: function() {
					}
				}
			});
		} else {
			alert('No data to make inactive!')
		}
	});
	$("#validateForm").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			//Validate create employee
			id: {
				required: true,
				notspace:true
			},
			dateOfBirth: {
				required: true,
				maxDate: true
			},
			email: {
				required: true,
				emailValidate: true,
				notspace:true
			},
			name: {
				required: true,
				maxlength: 100,
				notspace:true
				
			},
			phone: {
				required: true,
				phoneValidate: true,
				notspace:true
			},
			gender: {
				required: true,
			},
			address: {
				required: true,
				maxlength: 1000,
				notspace:true
			},
			//Validate create vaccine type
			code: {
				required: true,
				maxlength: 10,
				notspace:true
			},
			vaccineTypeName: {
				required: true,
				maxlength: 50,
				notspace:true
			},
			status: {
				required: true,
			},
			//Validate create schedule
			vaccine: {
				required: true,
				notspace:true
			},
			fromDate: {
				required: true,
				startDate: true,
			},
			toDate: {
				required: true,
			},
			place: {
				required: true,
			},
			status: {
				required: true,
			},

			//Validate create Vaccine
			vaccineId: {
				required: true,
				maxlength: 10,
				notspace:true
			},
			vaccineName: {
				required: true,
				maxlength: 50,
				notspace:true
			},
			type: {
				required: true,
			},
		},
		messages: {
			//Employee
			id: {
				required: "Id should not be blank",
			},
			dateOfBirth: {
				required: "Date of birth should not be blank",

			},
			email: {
				required: "Please input your correct email address",
			},
			name: {
				required: "Please input your name",
				maxlength: "Please input your name not greater than 100 character"
			},
			phone: {
				required: "Please input your correct phone number",
			},
			gender: {
				required: "Please select your gender",
			},
			address: {
				required: "Please input your address",
				maxlength: "Please input your address not greater than 1000 character"
			},
			//Vaccine type
			code: {
				required: "Please input vaccine type code",
				maxlength: "Please input vaccine type code not greater than 10 character"
			},
			vaccineTypeName: {
				required: "Please input vaccine type name",
				maxlength: "Please input vaccine type name not greater than 50 chacacter"
			},
			status: {
				required: "Please choose status",
			},
			//Schedule
			vaccine: {
				required: "Please input vaccine",
			},
			fromDate: {
				required: "Please input date",
			},
			toDate: {
				required: "Please input date",
			},
			place: {
				required: "Please input place",
			},
			status: {
				required: "Please input status",
			},
		},
		//Vaccine
		vaccineId: {
			required: "Please input Vaccine Id",
			maxlength: "Please input Vaccine Id not greater than 10 character",
		},
		vaccineName: {
			required: "Please input Vaccine Name",
			maxlength: "Please input Vaccine Name not greater than 10 character",
		},
		type: {
			required: "Please choose Vaccine Type",
		},
	});

	$("#vaccineForm").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			//Validate create Vaccine
			vaccineId: {
				required: true,
				maxlength: 10,
				notspace:true
			},
			vaccineName: {
				required: true,
				maxlength: 50,
				notspace:true
			},
			type: {
				required: true,
			},
			startDate: {
				startDate:true,
			}

		},
		messages: {

			//Vaccine
			vaccineId: {
				required: "Please input Vaccine Id",
				maxlength: "Please input Vaccine Id not greater than 10 character",
			},
			vaccineName: {
				required: "Please input Vaccine Name",
				maxlength: "Please input Vaccine Name not greater than 10 character",
			},
			type: {
				required: "Please choose Vaccine Type",
			},
		},
	});
	$.validator.addMethod(
		"emailValidate",
		function(value, element) {
			return (
				this.optional(element) ||
				/^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i.test(
					value
				)
			);
		},
		"Please input correct email address"
	);

	$.validator.addMethod(
		"phoneValidate",
		function(value, element) {
			return (
				this.optional(element) || /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/.test(value)
			);
		},
		"Please input your correct phone number"
	);
	$.validator.addMethod("maxDate", function(value, element) {
		var curDate = new Date();
		var inputDate = new Date(value);
		if (inputDate < curDate)
			return true;
		return false;
	}, "Birthday must be smaller than current date!");

	$.validator.addMethod("startDate", function(value, element) {
		var startDate = $("#startDate").val() 
		var endDate = $("#endDate").val() 
		if (startDate <= endDate)
			return true;
		return false;
	}, "StartDate must be smaller than EndDate!");
	
		jQuery.validator.addMethod("notspace", function(value, element) {
		return this.optional(element) || /^([^\s]*)$/.test(value);
	}, "Do not enter space in first position")
});
