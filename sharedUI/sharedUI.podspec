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
    