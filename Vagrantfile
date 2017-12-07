Vagrant.configure("2") do |config|
	config.vm.provider "virtualbox" do |v|
		v.memory = 1024
		v.cpus = 1
	end
	config.vm.box = "ubuntu/trusty64"
	config.vm.network "forwarded_port", guest: 8080, host:18080
	config.vm.provision "docker", run:"always" do |d|
	d.build_image "-t musicservice /vagrant"
		d.run "musicservice",
			args: "-p 8080:8080"
	end
end