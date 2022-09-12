/*
Copyright 2022.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package controllers

import (
	"context"

	"k8s.io/apimachinery/pkg/runtime"
	webappv1 "my.domain/guestbook/api/v1"
	ctrl "sigs.k8s.io/controller-runtime"
	"sigs.k8s.io/controller-runtime/pkg/client"
	"sigs.k8s.io/controller-runtime/pkg/log"
)

// CronJobReconciler reconciles a CronJob object
type CronJobReconciler struct {
	client.Client
	Scheme *runtime.Scheme
}

//+kubebuilder:rbac:groups=webapp.my.domain,resources=cronjobs,verbs=get;list;watch;create;update;patch;delete
//+kubebuilder:rbac:groups=webapp.my.domain,resources=cronjobs/status,verbs=get;update;patch
//+kubebuilder:rbac:groups=webapp.my.domain,resources=cronjobs/finalizers,verbs=update

// Reconcile is part of the main kubernetes reconciliation loop which aims to
// move the current state of the cluster closer to the desired state.
// TODO(user): Modify the Reconcile function to compare the state specified by
// the CronJob object against the actual cluster state, and then
// perform operations to make the cluster state reflect the state specified by
// the user.
//
// For more details, check Reconcile and its Result here:
// - https://pkg.go.dev/sigs.k8s.io/controller-runtime@v0.11.2/pkg/reconcile
func (r *CronJobReconciler) Reconcile(ctx context.Context, req ctrl.Request) (ctrl.Result, error) {
	log := log.FromContext(ctx)

	// TODO(user): your logic here
	var cronJob webappv1.CronJob
	if err := r.Get(ctx, req.NamespacedName, &cronJob); err != nil {
		log.Error(err, " unable to fetch cronjob")
		return ctrl.Result{}, client.IgnoreNotFound(err)
	}

	var cronjobs webappv1.CronJobList
	if err := r.List(ctx, &cronjobs, client.InNamespace(req.Namespace), client.MatchingFields{".spec.jobowner": "yudar"}); err != nil {
		log.Error(err, " unable get cronjoblist with name yudar")
		return ctrl.Result{}, client.IgnoreNotFound(err)
	}
	// if err := r.List(ctx, &cronjobs, client.InNamespace(req.Namespace), client.MatchingLabels{"app": "job"}); err != nil {
	// 	log.Error(err, " unable get cronjoblist with label app:job")
	// 	return ctrl.Result{}, client.IgnoreNotFound(err)
	// }
	for _, item := range cronjobs.Items {
		log.Info(item.Name + " owner= " + item.Spec.JobOwner + " was found in cluster with list*********")
	}
	log.Info(cronJob.Name + " was found in cluster********")

	return ctrl.Result{}, nil
}

var (
	jobOwnerKey = ".spec.jobowner"
	apiVersion  = "webapp.my.domain/v1"
)

// SetupWithManager sets up the controller with the Manager.
func (r *CronJobReconciler) SetupWithManager(mgr ctrl.Manager) error {
	if err := mgr.GetFieldIndexer().IndexField(context.Background(), &webappv1.CronJob{}, jobOwnerKey, func(rawObj client.Object) []string {
		job := rawObj.(*webappv1.CronJob)

		// ...make sure it's a CronJob...
		if job.APIVersion != apiVersion || job.Kind != "CronJob" {
			return nil
		}
		return []string{job.Spec.JobOwner}
	}); err != nil {
		return err
	}
	return ctrl.NewControllerManagedBy(mgr).
		For(&webappv1.CronJob{}).
		Complete(r)
}
