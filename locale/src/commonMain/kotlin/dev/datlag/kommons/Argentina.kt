package dev.datlag.kommons


data object Argentina : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ARG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(32)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(54)
}