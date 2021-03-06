angular.module('controllers',[]).controller('livingIndexCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state',
        'ElderUtil','GetUserInfo','GetCommunityBannerList',
        function ($scope,$interval,$rootScope,$stateParams,$state,
                  ElderUtil,GetUserInfo,GetCommunityBannerList) {

            $scope.param = {
                bannerList : '',
                activityList : ''
            }

            if($rootScope.rootElderId!=undefined)
            {
                $scope.elderId = $rootScope.rootElderId;
                $scope.elderName = $rootScope.rootElderName;
            }
            else
            {
                //将用户信息放入$rootScope中
                $rootScope.rootElderId = window.localStorage.getItem("elderId");
                $rootScope.rootElderName = window.localStorage.getItem("elderName");
                $rootScope.rootElderImg = window.localStorage.getItem("elderImg");
                if($rootScope.rootElderId!=undefined)
                {
                    $scope.elderId = $rootScope.rootElderId;
                    $scope.elderName = $rootScope.rootElderName;
                }
                else
                {
                    $scope.elderId = "0000";
                }
            }

            GetUserInfo.save(function(data){
                ElderUtil.checkResponseData(data,'livingIndex');
                GetCommunityBannerList.save(function(data){
                    ElderUtil.checkResponseData(data,'livingIndex');
                    $scope.param.bannerList = data.responseData;
                });
            })

            $scope.reserveService = function(beadHouseId){
                $state.go('beadHouseDetail',{beadHouseId:beadHouseId});
            }

        }])