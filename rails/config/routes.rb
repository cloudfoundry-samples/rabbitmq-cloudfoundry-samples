RabbitOnRails::Application.routes.draw do
  root :to => "home#index"

  get "home/index"
  match "publish" => "home#publish"
  match "get" => "home#get"
end
