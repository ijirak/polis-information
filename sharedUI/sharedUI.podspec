Pod::Spec.new do |spec|
    spec.name                     = 'sharedUI'
    spec.version                  = '1.0'
    spec.homepage                 = 'Link to the Shared Module homepage'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Some description for the Shared Module'
    spec.vendored_frameworks      = 'build/cocoapods/framework/sharedFront.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '14.1'
                
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':sharedUI',
        'PRODUCT_MODULE_NAME' => 'sharedFront',
    }
                
    spec.script_phases = [
        {
            :name => 'Build sharedUI',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :